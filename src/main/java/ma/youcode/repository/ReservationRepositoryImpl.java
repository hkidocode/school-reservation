package ma.youcode.repository;

import ma.youcode.model.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long countUsersReservationsInParticularDay(Date date) {
        Session session = sessionFactory.getCurrentSession();
        Long count = 0L;
        Query<Long> query = session.createQuery("SELECT COUNT(r) FROM Reservation r WHERE DATE(r.date) =:date and r.isValide = true ", Long.class);
        query.setParameter("date", date);
        try {
            count = query.getSingleResult();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return count;
    }

    @Override
    public Long countAcceptedReservationsForUser(Date date, Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        Long count = 0L;
        Query<Long> query = session.createQuery("SELECT COUNT(r) FROM Reservation r WHERE DATE(r.date) =:date AND r.user.idUser =:idUser AND r.isValide = true", Long.class);
        query.setParameter("date", date);
        query.setParameter("idUser", idUser);
        try {
            count = query.getSingleResult();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return count;
    }

    @Override
    public Long countNotAcceptedReservationsForUser(Date date, Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        Long count = 0L;
        Query<Long> query = session.createQuery("SELECT COUNT(r) FROM Reservation r WHERE DATE(r.date) =:date AND r.user.idUser =:idUser AND r.isValide = false", Long.class);
        query.setParameter("date", date);
        query.setParameter("idUser", idUser);
        try {
            count = query.getSingleResult();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return count;
    }

    @Override
    public BigInteger countReservationsBetweenNowAndLast7Days(Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        NativeQuery query = session.createSQLQuery("SELECT count(*) FROM reservations WHERE id_user = ? AND is_valide = true AND DATE(date) BETWEEN CURRENT_DATE - INTERVAL '7 days' AND CURRENT_DATE");
        query.setParameter(1, idUser);
        BigInteger count = BigInteger.valueOf(0);
        try {
            count = (BigInteger) query.getSingleResult();
            System.out.println(count);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Reservation> getAcceptedReservations(Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        List<Reservation> reservations = null;
        Query<Reservation> query = session.createQuery("SELECT r FROM Reservation r WHERE r.user.idUser =:idUser AND r.isValide = true ", Reservation.class);
        query.setParameter("idUser", idUser);
        try {
            reservations = query.getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return reservations;
    }

    @Override
    public List<Reservation> getNonAcceptedReservations(Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        List<Reservation> reservations = null;
        Query<Reservation> query = session.createQuery("SELECT r FROM Reservation r WHERE r.user.idUser =:idUser AND r.isValide = false ", Reservation.class);
        query.setParameter("idUser", idUser);
        try {
            reservations = query.getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return reservations;
    }

    @Override
    public List<Reservation> getAllReservationsOfUser(Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        List<Reservation> reservations = null;
        Query<Reservation> query = session.createQuery("SELECT r FROM Reservation r WHERE r.user.idUser =:idUser ", Reservation.class);
        query.setParameter("idUser", idUser);
        try {
            reservations = query.getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return reservations;
    }
}
