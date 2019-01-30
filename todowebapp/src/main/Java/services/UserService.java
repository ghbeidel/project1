package services;

import data.IUserDao;
import data.UserDao;
import entities.User;

public class UserService {
        private IUserDao userDao;

        public UserService() {
            this.userDao = new UserDao();
        }


        public User authUser(User u) {
            User dbUser =  this.userDao.getUserByEmail(u.getEmail());

            if(dbUser != null) {
                if(dbUser.getPassword().equals(u.getPassword())) {
                    dbUser.setPassword("");
                } else {

                    dbUser = null;
                }
            }

            return dbUser;
        }


    }


