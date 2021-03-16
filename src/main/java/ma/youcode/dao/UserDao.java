package ma.youcode.dao;

import ma.youcode.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.*;

public interface UserDao extends UserDetailsService {
    User getUser(Long idUser);
    void addUser(User user);
    void updateUser(User user, Long idUser);
    void deleteUser(User user);
    List<User> getAllUsers();
}
