package ma.youcode.dao;

import ma.youcode.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUser(Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        User user = null;
        try {
           user = session.get(User.class, idUser);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
           session.save(user);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user, Long idUser) {
        Session session = sessionFactory.getCurrentSession();
        try {
            User existentUser = getUser(idUser);
            existentUser.setName(user.getName());
            existentUser.setPhone(user.getPhone());
            existentUser.setEmail(user.getEmail());
            existentUser.setPassword(passwordEncoder.encode(user.getPassword()));
            existentUser.setReservations(user.getReservations());
            existentUser.setEnabled(user.getEnabled());
            session.update(existentUser);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(user);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = null;
        try {
            users = session.createQuery("SELECT u FROM User u", User.class).getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return users;
    }

}
