package ma.youcode.dao;

import ma.youcode.model.ReservationType;

import java.util.List;

public interface ReservationTypeDao {
    void addReservationType(ReservationType reservationType);
    ReservationType getReservationType(Long idReservationType);
    List<ReservationType> getAllReservationType();
}
