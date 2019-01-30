package data;

import entities.Reimb;
import entities.User;
import launcher.Launcher;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class ReimbDao implements IReimbDao{
    private static SessionFactory sessionFactory;
    Launcher launcher = new Launcher();

    public ReimbDao(){}

    public ReimbDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Reimb> getListOfReimb(){
        sessionFactory = launcher.configureSessionFactory();
        List<Reimb> list = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

            String hql = "from Reimb";
            Query q = session.createQuery(hql);

            list = q.list();
            tx.commit();


        return list;

    }



    @Override
    public void updateReimbStatus(User u, int statusId, Reimb reimb) {


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        String hql = "update Reimb set statusId, resolver =: status,resolver where reimbId =: reimbId";
        Query q = session.createQuery(hql);
        q.setParameter("statusId",statusId);
        q.setParameter("resolver",u.getId() );
        q.setParameter("reimbId", reimb.getReimbId());
        q.executeUpdate();

        tx.commit();
        session.close();


    }

}
