package data;

import entities.User;

import java.util.List;

public interface IUserDao {
    List<User> getAllUsers();
    User getUserById(int userId);
    User getUserByEmail(String email);
}
