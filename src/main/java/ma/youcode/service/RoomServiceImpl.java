package ma.youcode.service;

import ma.youcode.dao.RoomDao;
import ma.youcode.model.Room;
import ma.youcode.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room getRoom(Long idRoom) {
        return roomDao.getRoom(idRoom);
    }

    @Override
    public void addRoom(Room room) {
        roomDao.addRoom(room);
    }

    @Override
    public void updateRoom(Room room, Long idRoom) {
        roomDao.updateRoom(room, idRoom);
    }

    @Override
    public void deleteRoom(Room room) {
        roomDao.deleteRoom(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomDao.getAllRooms();
    }

    @Override
    public Room getRoomByDate(Date date) {
        return roomRepository.getRoomByDate(date);
    }

}
