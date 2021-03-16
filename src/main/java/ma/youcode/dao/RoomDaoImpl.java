package ma.youcode.dao;

import ma.youcode.HibernateUtil;
import ma.youcode.model.Reservation;
import ma.youcode.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {

    Session session = null;
    Transaction transaction = null;
    Room room = null;


    @Override
    public Room getRoom(Long idRoom) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            room = session.get(Room.class, idRoom);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return room;
    }

    @Override
    public void addRoom(Room room) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(room);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room, Long idRoom) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Room existentRoom = getRoom(idRoom);
            existentRoom.setReservations(room.getReservations());
            existentRoom.setDate(room.getDate());
            existentRoom.setUsersNum(room.getUsersNum());
            existentRoom.setContainsEvent(room.isContainsEvent());
            session.update(existentRoom);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(Room room) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(room);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            rooms = session.createQuery("SELECT rm FROM Room rm", Room.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return rooms;
    }
}
