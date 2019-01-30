package services;

import data.IUserDao;
import data.UserDao;
import entities.User;

import javax.servlet.ServletException;

public class UserService {

        private IUserDao userDao;

        public UserService() {
            this.userDao = new UserDao();
        }



        public User authUser(User u) {
            User dbUser =  this.userDao.getUserById(u.getId());

            if(dbUser != null) {
                if(dbUser.getPassword_hash().equals(u.getPassword_hash())) {
                    dbUser.setPassword_hash("");
                } else {
                    dbUser = null;
                }
            }

            return dbUser;
        }


    }


