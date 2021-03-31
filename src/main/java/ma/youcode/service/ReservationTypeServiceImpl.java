package ma.youcode.service;

import ma.youcode.dao.ReservationTypeDao;
import ma.youcode.model.ReservationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationTypeServiceImpl implements ReservationTypeService {

    @Autowired
    private ReservationTypeDao reservationTypeDao;

    @Override
    public void addReservationType(ReservationType reservationType) {
        reservationTypeDao.addReservationType(reservationType);
    }

    @Override
    public ReservationType getReservationType(int idReservationType) {
        return reservationTypeDao.getReservationType(idReservationType);
    }

    @Override
    public List<ReservationType> getAllReservationType() {
        return reservationTypeDao.getAllReservationType();
    }

}
