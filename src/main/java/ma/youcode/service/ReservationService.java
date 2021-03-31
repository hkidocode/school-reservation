package ma.youcode.service;

import ma.youcode.model.Reservation;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

public interface ReservationService {
    Reservation getReservation(Long idReservation);
    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation, Long idReservation);
    void deleteReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    List<Reservation> getAcceptedReservations(Long idUser);
    List<Reservation> getNonAcceptedReservations(Long idUser);
    List<Reservation> getAllReservationsOfUser(Long idUser);
    Long countUsersReservationsInParticularDay(Date date);
    BigInteger countReservationsBetweenNowAndLast7Days(Long idUser);
    Long countAcceptedReservationsForUser(Date date, Long idUser);
    Long countNotAcceptedReservationsForUser(Date date, Long idUser);

}
