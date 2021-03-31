package ma.youcode.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAllReservationInRoom(Date date) {
        Session session = sessionFactory.getCurrentSession();
        List listUsersInRoom = null;
        Query query = session.createQuery("SELECT u.name, u.phone, rt.name AS rsvName FROM User u " +
                "INNER JOIN Reservation r INNER JOIN ReservationType rt WHERE r.date=:date").setParameter("date", date);
        try {
            listUsersInRoom = query.getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return listUsersInRoom;
    }
}
