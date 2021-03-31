package ma.youcode.repository;

import java.util.*;
import java.sql.Date;

public interface AdminRepository {
    List getAllReservationInRoom(Date date);
}
