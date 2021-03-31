package ma.youcode.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Long idSession;
    @Column(name = "users_num", nullable = false)
    private int usersNum;
    @Column(nullable = false)
    private Date date;
    @Column(name = "contains_event", nullable = false)
    @ColumnDefault("false")
    private boolean containsEvent;
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Room(int usersNum, Date date) {
        this.usersNum = usersNum;
        this.date = date;
    }

    public Room(int usersNum, Date date, boolean containsEvent) {
        this.usersNum = usersNum;
        this.date = date;
        this.containsEvent = containsEvent;
    }

    public Room(Long idSession, int usersNum, Date date, boolean containsEvent, List<Reservation> reservations) {
        this.idSession = idSession;
        this.usersNum = usersNum;
        this.date = date;
        this.containsEvent = containsEvent;
        this.reservations = reservations;
    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public int getUsersNum() {
        return usersNum;
    }

    public void setUsersNum(int usersNum) {
        this.usersNum = usersNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isContainsEvent() {
        return containsEvent;
    }

    public void setContainsEvent(boolean containsEvent) {
        this.containsEvent = containsEvent;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
