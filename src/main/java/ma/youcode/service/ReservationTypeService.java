package ma.youcode.service;

import ma.youcode.model.Reservation;
import ma.youcode.model.ReservationType;

import java.util.List;

public interface ReservationTypeService {
    void addReservationType(ReservationType reservationType);
    ReservationType getReservationType(int idReservationType);
    List<ReservationType> getAllReservationType();
}
