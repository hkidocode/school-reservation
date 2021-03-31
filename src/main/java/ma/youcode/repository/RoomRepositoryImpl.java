package ma.youcode.repository;
import ma.youcode.model.Reservation;
import ma.youcode.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Date;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Room getRoomByDate(Date date) {
        Session session = sessionFactory.getCurrentSession();
        Room room = null;
        try {
            Query<Room> query = session.createQuery("SELECT r FROM Room r WHERE r.date =:date ", Room.class);
            query.setParameter("date", date);
            room = query.getSingleResult();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return room;
    }

}
