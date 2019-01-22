package launcher;


import entities.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


public class Launcher {
    static SessionFactory sessionFactory;


    public SessionFactory configureSessionFactory() {
        Configuration configuration = new Configuration()
                .setProperties(setSessionFactoryProperties());

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Reimb.class);
        configuration.addAnnotatedClass(Status.class);
        configuration.addAnnotatedClass(Type.class);
        configuration.addAnnotatedClass(Role.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private Properties setSessionFactoryProperties() {
        Properties temp = new Properties();

        temp.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        temp.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        temp.setProperty("hibernate.connection.username","grant_beidel");
        temp.setProperty("hibernate.connection.password","password123");
        temp.setProperty("hibernate.connection.url", "jdbc:postgresql://sparknov27.cpijza42wykv.us-east-2.rds.amazonaws.com:5432/inclass");
        temp.setProperty("hibernate.connection.pool_size","1");

        temp.setProperty("hibernate.hbm2ddl.auto","update");
        temp.setProperty("hibernate.show_sql","true");
        temp.setProperty("hibernate.format_sql","true");


        return temp;
    }

    public User getUserDemo(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User u = null;

        // get is direct query to the DB
        // returns the specified object by id
        // or null if id is not found
        u = (User) session.get(User.class, id);

        tx.commit();
        session.close();

        return u;
    }

    public void createRole(){
        Role r = new Role();
        r.setRole("Manager");

        Role r2 = new Role();
        r2.setRole("Employee");

        Session session = sessionFactory.openSession();
        Transaction tx =  session.beginTransaction();

        session.save(r);
        session.save(r2);
        tx.commit();
        session.close();

    }

    public void createUsers(){




//        User user = new User();
//        user.setEmail("g@gmail.com");
//        user.setFirstName("Grant");
//        user.setLastName("Beidel");
//        user.setUserName("gbeidel");
//        user.setRoleId(ur);
//
//
//        Type rt = new Type();
//        rt.setTypeId(1);
//
//        Status rs = new Status();
//        rs.setStatusId(1);
//
//        Reimb r = new Reimb();
//        r.setAmount(100);
//        r.setAuthor(user);
//        r.setTypeId(rt);
//
//        r.setTypeId(rt);
//        r.setStatusId(rs);
//
//        Set<User> users = new HashSet<>();
//        users.add(user);



        Session session =  sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        tx.commit();

        session.close();

    }



}
