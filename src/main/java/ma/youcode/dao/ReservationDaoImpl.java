package ma.youcode.dao;

import ma.youcode.HibernateUtil;
import ma.youcode.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao {
    Session session = null;
    Transaction transaction = null;
    Reservation reservation = null;

    @Override
    public Reservation getReservation(Long idReservation) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            reservation = session.get(Reservation.class, idReservation);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void addReservation(Reservation reservation) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(reservation);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateReservation(Reservation reservation, Long idReservation) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Reservation existentReservation = getReservation(idReservation);
            existentReservation.setReservationType(reservation.getReservationType());
            existentReservation.setDate(reservation.getDate());
            existentReservation.setUser(reservation.getUser());
            existentReservation.setRoom(reservation.getRoom());
            existentReservation.setIsValide(reservation.getIsValide());
            session.update(existentReservation);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(reservation);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            reservations = session.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return reservations;
    }

}
