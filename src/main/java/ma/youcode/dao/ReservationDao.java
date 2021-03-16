package ma.youcode.dao;

import ma.youcode.model.Reservation;
import ma.youcode.model.User;

import java.util.List;

public interface ReservationDao {
    Reservation getReservation(Long idReservation);
    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation, Long idReservation);
    void deleteReservation(Reservation reservation);
    List<Reservation> getAllReservations();
}
