package ma.youcode.repository;

import ma.youcode.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

   @Autowired
   private SessionFactory sessionFactory;

    @Override
    public List<User> getAllNonEnableAndInactiveUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = null;
        try {
            users =  session.createQuery("SELECT u FROM User u WHERE u.enabled = false AND u.actived = true ", User.class).getResultList();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return users;
    }

    @Override
    public void enableUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            user.setEnabled(true);
            session.update(user);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void inactivateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            user.setActived(false);
            session.update(user);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        User user = null;
        Query<User> query = session.createQuery("SELECT u from User u where u.email =:email", User.class);
        query.setParameter("email", email);
        try {
            user = query.getSingleResult();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return user;
    }
}
