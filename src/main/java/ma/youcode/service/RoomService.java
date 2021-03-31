package ma.youcode.service;

import ma.youcode.model.Room;

import java.sql.Date;
import java.util.List;

public interface RoomService {
    Room getRoom(Long idRoom);
    void addRoom(Room room);
    void updateRoom(Room room, Long idRoom);
    void deleteRoom(Room room);
    List<Room> getAllRooms();
    Room getRoomByDate(Date date);
}
