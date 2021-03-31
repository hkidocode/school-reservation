package ma.youcode.service;

import ma.youcode.dao.UserDao;
import ma.youcode.model.User;
import ma.youcode.model.UserRole;
import ma.youcode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
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
        userDao.updateUser(user, idUser);
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
    public List<User> getAllNonEnableAndInactiveUsers() {
        return userRepository.getAllNonEnableAndInactiveUsers();
    }

    @Override
    public void enableUser(User user) {
        userRepository.enableUser(user);
    }

    @Override
    public void inactivateUser(User user) {
        userRepository.inactivateUser(user);
    }

    @Override
    public User findByEmail(String email) {
        // check the database if the user already exists
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new
                org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getUserRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(UserRole userRole) {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

}
