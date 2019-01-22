//package services;
//
//import entities.User;
//
//public class UserService {
//
//        private User user;
//
//        public UserService() {
//            this.user = new User();
//        }
//
//        public User authUser(User u) {
//            User user =  this.user.getByEmail(u.getEmail());
//
//            if(user != null) {
//                if(user.getPassword().equals(u.getPassword())) {
//                    user.setPassword("");
//                } else {
//                    user = null;
//                }
//            }
//
//            return user;
//        }
//
//
//    }
//
//}
