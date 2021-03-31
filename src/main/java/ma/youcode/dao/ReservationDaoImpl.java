package ma.youcode.dao;

import ma.youcode.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Reservation getReservation(Long idReservation) {
        Session session = sessionFactory.getCurrentSession();
        Reservation reservation = null;
        try {
            reservation = session.get(Reservation.class, idReservation);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void addReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(reservation);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateReservation(Reservation reservation, Long idReservation) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Reservation existentReservation = getReservation(idReservation);
            existentReservation.setReservationType(reservation.getReservationType());
            existentReservation.setDate(reservation.getDate());
            existentReservation.setUser(reservation.getUser());
            existentReservation.setRoom(reservation.getRoom());
            existentReservation.setIsValide(reservation.getIsValide());
            session.update(existentReservation);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(reservation);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        Session session = sessionFactory.getCurrentSession();
        List<Reservation> reservations = null;
        try {
            reservations = session.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return reservations;
    }

}
