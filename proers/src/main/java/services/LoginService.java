package services;

import entities.User;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
   private static SessionFactory sessionFactory;

    public boolean authenticate(String userName, String password){

        User user = getUserByUserName(userName);

        if(user != null && user.getPassword().equals(password) && user.getUserName().equals(userName)){
            return true;
        }else{

        return false;

        }
    }


    public User getIdByUserName(String userName){

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        User user = null;

        try{
            session.beginTransaction();
            tx.begin();

            String hql = "from ers_users where userName := userName";
            Query query = session.createQuery(hql);

            user = (User)query.uniqueResult();
            tx.commit();

        }catch(HibernateException h){

        }
        return user;

    }

    public List<User> getListOfUsers(){
        List<User> list = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
       try {
           tx = session.beginTransaction();
           tx.begin();

           String hql = "from ERS_USERS ";
           list = session.createQuery("from ers_user").list();

           tx.commit();
       }catch(HibernateException e){
            tx.rollback();
           System.out.println("session error ");
       }finally{
           session.close();
        }

        return list;

    }
}
