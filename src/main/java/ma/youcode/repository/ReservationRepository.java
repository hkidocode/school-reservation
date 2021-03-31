package ma.youcode.repository;

import ma.youcode.model.Reservation;

import java.math.BigInteger;
import java.util.*;
import java.sql.Date;

public interface ReservationRepository {
    Long countUsersReservationsInParticularDay(Date date);
    Long countAcceptedReservationsForUser(Date date, Long idUser);
    Long countNotAcceptedReservationsForUser(Date date, Long idUser);
    BigInteger countReservationsBetweenNowAndLast7Days(Long idUser);
    List<Reservation> getAcceptedReservations(Long idUser);
    List<Reservation> getNonAcceptedReservations(Long idUser);
    List<Reservation> getAllReservationsOfUser(Long idUser);
}
