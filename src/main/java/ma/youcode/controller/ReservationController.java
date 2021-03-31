package ma.youcode.controller;

import ma.youcode.model.Reservation;
import ma.youcode.model.ReservationType;
import ma.youcode.model.Room;
import ma.youcode.model.User;
import ma.youcode.service.ReservationService;
import ma.youcode.service.ReservationTypeService;
import ma.youcode.service.RoomService;
import ma.youcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;


@Controller
public class ReservationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationTypeService reservationTypeService;

    @Autowired
    private RoomService roomService;

    String textMessage = "";


    @GetMapping("/reservation")
    public String reservation(Model model) {
        if (reservationService.countReservationsBetweenNowAndLast7Days(1L).compareTo(BigInteger.valueOf(3)) >= 1L){
            textMessage = "Vous avez passer la limite de présence par semaine!";
        }
        model.addAttribute("reservationTypes", reservationTypeService.getAllReservationType());
        model.addAttribute("allReservations", reservationService.getAllReservationsOfUser(1L));
        model.addAttribute("acceptedReservations", reservationService.getAcceptedReservations(1L));
        model.addAttribute("nonAcceptedReservations", reservationService.getNonAcceptedReservations(1L));
        model.addAttribute("textMessage", textMessage);
        return "reservation";
    }

    @PostMapping("/reservation/insert")
    public String insert(@RequestParam(value = "date-rsv") String date,
                            @RequestParam int rsvType) {
        Date dateRsv = Date.valueOf(date);
        Timestamp timestampRsv = new Timestamp(System.currentTimeMillis());
        Timestamp timestampDayStart = Timestamp.valueOf(date + " 08:00:00.000");
        Timestamp timestampDayEnd = Timestamp.valueOf(date + " 09:00:00.000");
        User user = userService.getUser(1L);
        ReservationType reservationType = reservationTypeService.getReservationType(rsvType);
        Room room = roomService.getRoomByDate(dateRsv);
        Reservation reservation = new Reservation(timestampRsv, user, reservationType, room, true);
        if (roomService.getRoomByDate(dateRsv) == null) {
            textMessage = "La date choisie est dépassé ou encore indisponible!";
        } else  {
            if (reservationType.getName().equals("Journée")) {
                if (timestampRsv.compareTo(timestampDayStart) >= 0 && timestampRsv.compareTo(timestampDayEnd) <= 0) {
                    if (reservationService.countAcceptedReservationsForUser(new Date(timestampRsv.getTime()), 1L) == 0L) {
                        reservationService.addReservation(reservation);
                        textMessage = "Réservation réussie.";
                    } else {
                        textMessage = "Vous avez déja réserver cette journée!";
                    }
                } else {
                    textMessage = "Les réservations ne sont pas encore ouvertes.";
                }
            } else {
                Timestamp timestampEveningStart = Timestamp.valueOf(date + " 20:20:00.000");
                Timestamp timestampEveningEnd = Timestamp.valueOf(date + " 23:30:00.000");
                if (timestampRsv.compareTo(timestampEveningStart) >= 0 && timestampRsv.compareTo(timestampEveningEnd) <= 0) {
                    if ((reservationService.countUsersReservationsInParticularDay(new Date(timestampRsv.getTime())) + 1) > room.getUsersNum()) {
                        if (reservationService.countNotAcceptedReservationsForUser(new Date(timestampRsv.getTime()), 1L) < 1L) {
                            reservation.setIsValide(false);
                            reservationService.addReservation(reservation);
                        }
                        textMessage = "Les réservations sont saturés!";
                    } else if ((reservationService.countUsersReservationsInParticularDay(new Date(timestampRsv.getTime())) + 1) <= room.getUsersNum()) {
                        if (reservationService.countAcceptedReservationsForUser(new Date(timestampRsv.getTime()), 1L) == 0L) {
                            reservationService.addReservation(reservation);
                            textMessage = "Réservation réussie.";
                        } else if (reservationService.countAcceptedReservationsForUser(new Date(timestampRsv.getTime()), 1L) == 1L)  {
                            textMessage = "Vous avez déja réserver cette journée!";
                        }
                    }
                } else {
                    textMessage = "Les réservations ne sont pas encore ouvertes.";
                }
            }
        }

        return "redirect:/reservation";

    }
}

