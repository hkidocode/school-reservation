package ma.youcode.dao;

import ma.youcode.model.User;

import java.util.*;

public interface UserDao {
    User getUser(Long idUser);
    void addUser(User user);
    void updateUser(Long idUser);
    void deleteUser(Long idUser);
    List<User> getAllUsers();
}
