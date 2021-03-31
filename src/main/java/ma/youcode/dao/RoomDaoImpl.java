package ma.youcode.dao;

import ma.youcode.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Room getRoom(Long idRoom) {
        Session session = sessionFactory.getCurrentSession();
        Room room = null;
        try {
            room = session.get(Room.class, idRoom);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return room;
    }

    @Override
    public void addRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(room);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room, Long idRoom) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Room existentRoom = getRoom(idRoom);
            existentRoom.setReservations(room.getReservations());
            existentRoom.setDate(room.getDate());
            existentRoom.setUsersNum(room.getUsersNum());
            existentRoom.setContainsEvent(room.isContainsEvent());
            session.update(existentRoom);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(room);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public List<Room> getAllRooms() {
        Session session = sessionFactory.getCurrentSession();
        List<Room> rooms = null;
        try {
            rooms = session.createQuery("SELECT rm FROM Room rm", Room.class).getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return rooms;
    }
}
