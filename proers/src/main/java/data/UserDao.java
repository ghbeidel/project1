package data;

import entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {

    private static SessionFactory sessionFactory;



    public UserDao(){}
    public UserDao(SessionFactory sessionFactory){
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
}


