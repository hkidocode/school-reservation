package ma.youcode.service;

import ma.youcode.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUser(Long idUser);
    void addUser(User user);
    void updateUser(User user, Long idUser);
    void deleteUser(User user);
    List<User> getAllUsers();
    List<User> getAllNonEnableAndInactiveUsers();
    void enableUser(User user);
    void inactivateUser(User user);
    User findByEmail(String email);
}
