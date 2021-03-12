package ma.youcode.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    public User() {
    }

    public User(String name, String phone, List<Reservation> reservations, String email, String password, boolean isAdmin) {
        this.name = name;
        this.phone = phone;
        this.reservations = reservations;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String phone, String email, String password, boolean isAdmin) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(Long idUser, String name, String phone, List<Reservation> reservations, String email, String password, boolean isAdmin) {
        this.idUser = idUser;
        this.name = name;
        this.phone = phone;
        this.reservations = reservations;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
