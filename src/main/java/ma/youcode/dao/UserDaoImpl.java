package ma.youcode.dao;

import ma.youcode.HibernateUtil;
import ma.youcode.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    Session session = null;
    Transaction transaction = null;
    User user = null;

    @Override
    public User getUser(Long idUser) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, idUser);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user, Long idUser) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            User existentUser = getUser(idUser);
            existentUser.setName(user.getName());
            existentUser.setPhone(user.getPhone());
            existentUser.setEmail(user.getEmail());
            existentUser.setPassword(user.getPassword());
            existentUser.setReservations(user.getReservations());
            existentUser.setEnabled(user.getEnabled());
            session.update(existentUser);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            users = session.createQuery("SELECT u FROM User u", User.class).getResultList();
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
