package data;

import entities.User;
import launcher.Launcher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao implements IUserDao {

    private static SessionFactory sessionFactory;


    public UserDao() {
    }

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<User> users = null;

        String hql = "from User";
        Query q = session.createQuery(hql);

        users = q.list();

        tx.commit();
        session.close();

        return users;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    public User getUserByEmail(String email) {
        Launcher launcher = new Launcher();
        sessionFactory = launcher.configureSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User u = new User();

        System.out.println("A new User has been created");

        String hql = "from User where email = :email";
        Query q = session.createQuery(hql);
        q.setParameter("email", email);



        u = (User) q.uniqueResult();

        System.out.println("User Email:" + u.getEmail());
        System.out.println("User Password:" + u.getPassword());
        tx.commit();
        session.close();

        return u;
    }

}
