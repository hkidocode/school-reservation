package ma.youcode.service;

import ma.youcode.dao.UserDao;
import ma.youcode.model.User;
import ma.youcode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long idUser) {
        return userDao.getUser(idUser);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user, Long idUser) {
        updateUser(user, idUser);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getAllNonEnableUsers() {
        return userRepository.getAllNonEnableUsers();
    }

    @Override
    public void enableUser(User user) {
        userRepository.enableUser(user);
    }


}
