package ma.youcode.dao;

import ma.youcode.model.Reservation;
import ma.youcode.model.Room;
import java.util.List;

public interface RoomDao {
    Room getRoom(Long idRoom);
    void addRoom(Room room);
    void updateRoom(Room room, Long idRoom);
    void deleteRoom(Room room);
    List<Room> getAllRooms();
}
