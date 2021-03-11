import model.ReservationType;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        try {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        transaction = session.beginTransaction();
        transaction.commit();
        } catch(Exception throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            throwable.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
