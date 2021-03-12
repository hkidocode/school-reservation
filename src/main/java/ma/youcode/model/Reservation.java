package ma.youcode.model;

import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long idReservation;
    @Column(nullable = false)
    private Timestamp date;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToOne
    @JoinColumn(name = "id_reservation_type")
    private ReservationType reservationType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable( name = "room_reservation",
            joinColumns = @JoinColumn( name = "id_reservation" ),
            inverseJoinColumns = @JoinColumn( name = "id_room" ) )
    private Room room;
    @Column(name = "is_valide", nullable = false)
    @ColumnDefault("true")
    private boolean isValide;

    public Reservation() {
    }

    public Reservation(Timestamp date, User user, ReservationType reservationType, Room room, boolean isValide) {
        this.date = date;
        this.user = user;
        this.reservationType = reservationType;
        this.room = room;
        this.isValide = isValide;
    }

    public Reservation(Long idReservation, Timestamp date, User user, ReservationType reservationType, Room room, boolean isValide) {
        this.idReservation = idReservation;
        this.date = date;
        this.user = user;
        this.reservationType = reservationType;
        this.room = room;
        this.isValide = isValide;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public boolean isValide() {
        return isValide;
    }

    public void setValide(boolean valide) {
        isValide = valide;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
