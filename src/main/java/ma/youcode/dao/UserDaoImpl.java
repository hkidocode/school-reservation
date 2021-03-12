package ma.youcode.dao;

import ma.youcode.HibernateUtil;
import ma.youcode.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {
    Session session = null;
    Transaction transaction = null;
    User user = null;

    @Override
    public User getUser(Long idUser) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            user = session.get(User.class, idUser);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

        return user;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(Long idUser) {

    }

    @Override
    public void deleteUser(Long idUser) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
