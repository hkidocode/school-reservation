package ma.youcode.service;

import ma.youcode.model.User;
import java.util.List;

public interface UserService {
    User getUser(Long idUser);
    void addUser(User user);
    void updateUser(User user, Long idUser);
    void deleteUser(User user);
    List<User> getAllUsers();
    List<User> getAllNonEnableUsers();
    void enableUser(User user);

}
