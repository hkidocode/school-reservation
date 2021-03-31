package ma.youcode.dao;

import ma.youcode.model.ReservationType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservationTypeDaoImpl implements ReservationTypeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ReservationType> getAllReservationType() {
        List<ReservationType> reservationTypes = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            reservationTypes =  session.createQuery("SELECT rt FROM ReservationType rt", ReservationType.class).getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return reservationTypes;
    }

    @Override
    public void addReservationType(ReservationType reservationType) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(reservationType);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public ReservationType getReservationType(int idReservationType) {
        Session session = sessionFactory.getCurrentSession();
        ReservationType reservationType = null;
        try {
            reservationType = session.get(ReservationType.class, idReservationType);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return reservationType;
    }
}
