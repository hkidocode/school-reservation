package ma.youcode.model;


import javax.persistence.*;

@Entity
@Table(name = "reservation_type")
public class ReservationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation_type")
    private int idReservationType;
    @Column(nullable = false, unique = true)
    private String name;

    public ReservationType() {
    }

    public ReservationType(String name) {
        this.name = name;
    }

    public ReservationType(int idReservationType, String name) {
        this.idReservationType = idReservationType;
        this.name = name;
    }

    public int getIdReservationType() {
        return idReservationType;
    }

    public void setIdReservationType(int idReservationType) {
        this.idReservationType = idReservationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
