package data;

import entities.Reimb;
import entities.User;

import java.util.List;

public interface IReimbDao {
    List<Reimb> getListOfReimb();

    void updateReimbStatus(User u, int id, Reimb reimb);

}
