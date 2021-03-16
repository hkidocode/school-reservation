package ma.youcode.model;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
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
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean enabled = false;
    public User() {
    }

    public User(String name, String phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public User(Long idUser, String name, String phone, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public User(String name, String phone, String email, String password, UserRole userRole) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }



    public User(Long idUser, String name, String phone, String email, String password, UserRole userRole) {
        this.idUser = idUser;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(String name, String phone, List<Reservation> reservations, String email, String password, UserRole userRole) {
        this.name = name;
        this.phone = phone;
        this.reservations = reservations;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(Long idUser, String name, String phone, List<Reservation> reservations, String email, String password, UserRole userRole) {
        this.idUser = idUser;
        this.name = name;
        this.phone = phone;
        this.reservations = reservations;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
