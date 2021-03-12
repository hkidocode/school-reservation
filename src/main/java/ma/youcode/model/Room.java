package ma.youcode.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Long idSession;
    @Column(name = "users_num", nullable = false)
    @ColumnDefault("30")
    private int usersNum;
    @Column(nullable = false)
    private Timestamp date;
    @Column(name = "contains_event", nullable = false)
    @ColumnDefault("false")
    private boolean containsEvent;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "room_reservation",
            joinColumns = @JoinColumn( name = "id_room" ),
            inverseJoinColumns = @JoinColumn( name = "id_reservation" ) )
    private List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Room(int usersNum, Timestamp date, boolean containsEvent, List<Reservation> reservations) {
        this.usersNum = usersNum;
        this.date = date;
        this.containsEvent = containsEvent;
        this.reservations = reservations;
    }

    public Room(Long idSession, int usersNum, Timestamp date, boolean containsEvent, List<Reservation> reservations) {
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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
