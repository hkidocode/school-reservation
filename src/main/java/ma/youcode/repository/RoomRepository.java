package ma.youcode.repository;

import ma.youcode.model.Room;

import java.sql.Date;

public interface RoomRepository {
    Room getRoomByDate(Date date);
}
