package ma.youcode.repository;

import ma.youcode.HibernateUtil;
import ma.youcode.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    Session session = null;
    Transaction transaction = null;

    @Override
    public List<User> getAllNonEnableUsers() {
        List<User> users = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            users = session.createQuery("SELECT u FROM User u WHERE u.enabled = false", User.class).getResultList();
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
    public void enableUser(User user) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            user.setEnabled(true);
            session.update(user);
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        }
    }
}
