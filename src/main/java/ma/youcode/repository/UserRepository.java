package ma.youcode.repository;

import ma.youcode.model.User;
import java.util.List;

public interface UserRepository {
    List<User> getAllNonEnableAndInactiveUsers();
    void enableUser(User user);
    void inactivateUser(User user);
    User findByEmail(String email);
}
