package launcher;

import data.UserDao;
import entities.Reimb;
import entities.Status;
import entities.Type;
import entities.User;
import org.hibernate.SessionFactory;


import java.sql.Timestamp;

public class Main {
    static SessionFactory sessionFactory;


    public static void main(String[] args) {
        Main main = new Main();

        Launcher launcher = new Launcher();
        sessionFactory = launcher.configureSessionFactory();


//        for(Reimb r : reimbDao.getListOfReimb() ){
//            System.out.println(r);
//        }


        UserDao userDao = new UserDao(sessionFactory);
//        for(User u  : userDao.getAllUsers()){
//            System.out.println(u);
//        }

        System.out.println( userDao.getUserByEmail("g@gmail.com"));

    }











//
//    public SessionFactory configureSessionFactory() {
//        Configuration configuration = new Configuration()
//                .setProperties(setSessionFactoryProperties());
//
//        configuration.addAnnotatedClass(User.class);
//        configuration.addAnnotatedClass(Reimb.class);
//        configuration.addAnnotatedClass(Status.class);
//        configuration.addAnnotatedClass(Type.class);
//        configuration.addAnnotatedClass(Role.class);
//
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//
//        return configuration.buildSessionFactory(serviceRegistry);
//    }
//
//    private Properties setSessionFactoryProperties() {
//        Properties temp = new Properties();
//
//        temp.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//        temp.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
//        temp.setProperty("hibernate.connection.username","grant_beidel");
//        temp.setProperty("hibernate.connection.password","password123");
//        temp.setProperty("hibernate.connection.url", "jdbc:postgresql://sparknov27.cpijza42wykv.us-east-2.rds.amazonaws.com:5432/inclass");
//        temp.setProperty("hibernate.connection.pool_size","1");
//
//        //temp.setProperty("hibernate.hbm2ddl.auto","update");
//        temp.setProperty("hibernate.show_sql","true");
//        temp.setProperty("hibernate.format_sql","true");
//
//
//        return temp;
//    }
//// already created the roles employee and manager
//    public void createRole(){
//        Role r = new Role();
//        r.setRoleId(1);
//        r.setRole("Manager");
//
//        Role r2 = new Role();
//        r2.setRole("Employee");
//        r2.setRoleId(2);
//        Session session = sessionFactory.openSession();
//        Transaction tx =  session.beginTransaction();
//
//        session.save(r);
//        session.save(r2);
//
//        tx.commit();
//        session.close();
//
//    }

//    public void createUser(){
//
//        Role manager = new Role();
//
//        manager.setRole("Manager");
//
//        Role employee = new Role();
//
//        employee.setRole("Employee");
//
//        User userA = new User();
//        userA.setUserName("gbeidel");
//        userA.setLastName("Beidel");
//        userA.setFirstName("Grant");
//        userA.setEmail("g@gmail.com");
//        userA.setRoleId(employee);
//
//
//        User userB = new User();
//        userB.setUserName("antman");
//        userB.setEmail("a@gmail.com");
//        userB.setFirstName("Anthony");
//        userB.setLastName("Le");
//
//        userB.setRoleId(manager);
//
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        session.save(userA);
//        session.save(userB);
//
//        tx.commit();
//        session.close();
//    }

//    public void createStatus(){
//        Status pend = new Status();
//        Status app = new Status();
//        Status deny = new Status();
//
//        pend.setStatus("Pending");
//        app.setStatus("Approved");
//        deny.setStatus("Denied");
//
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        session.save(pend);
//        session.save(app);
//        session.save(deny);
//
//        tx.commit();
//        session.close();
//
//    }

//    public void createType(){
//        Type food = new Type();
//        food.setType("Food");
//
//        Type lodging= new Type();
//        lodging.setType("Lodging");
//
//        Type travel = new Type();
//        travel.setType("Travel");
//
//        Type other = new Type();
//        other.setType("Other");
//
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//
//        session.save(food);
//        session.save(lodging);
//        session.save(travel);
//        session.save(other);
//
//        tx.commit();
//        session.close();
//    }
Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    public void createReimb(Status status, Type type, User user){
        user.setUserName("antman");
        status.setStatusId(1);
        type.setTypeId(1);
        Reimb reimb = new Reimb();
        reimb.setStatusId(status);
        reimb.setAmount(100);
        reimb.setDescription("This was for food");

    }


}
