package ma.youcode.dao;

import ma.youcode.HibernateUtil;
import ma.youcode.model.ReservationType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservationTypeDaoImpl implements ReservationTypeDao{

    Session session = null;
    Transaction transaction = null;
    ReservationType reservationType = null;

    @Override
    public List<ReservationType> getAllReservationType() {
        List<ReservationType> reservationTypes = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            reservationTypes = session.createQuery("SELECT rt FROM ReservationType rt", ReservationType.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return reservationTypes;
    }

    @Override
    public void addReservationType(ReservationType reservationType) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(reservationType);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public ReservationType getReservationType(Long idReservationType) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            reservationType =  session.get(ReservationType.class, idReservationType);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return reservationType;
    }
}
