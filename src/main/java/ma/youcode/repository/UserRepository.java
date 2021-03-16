package ma.youcode.repository;

import ma.youcode.model.User;
import java.util.List;

public interface UserRepository {
    List<User> getAllNonEnableUsers();
    void enableUser(User user);
}
