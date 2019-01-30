package services;

import data.IReimbDao;
import data.ReimbDao;
import data.UserDao;
import entities.Reimb;
import entities.Role;
import entities.User;

import java.util.List;

public class ReimbService {

    private IReimbDao reimbDao;

    public ReimbService() {
        this.reimbDao = new ReimbDao();
    }

    public List<Reimb> getAllReimbs(User u) {
        List<Reimb> reimbs = this.reimbDao.getListOfReimb();
        Role role = new Role();


        if (u != null) {
            if (u.getRoleId().equals("Manager")) {
                return reimbs;
            }else if (u.getRoleId().equals("Employee")) {
                return reimbs;
            }
            }else{
                reimbs = null;
            }



            return reimbDao.getListOfReimb();


    }
}
