package servlets;



import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import services.LoginService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService;

    public void init() throws ServletException{
        userService = new UserService();

        try{
            Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
        }catch(ClassNotFoundException e){
            throw new ServletException("can't load jackson");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User authUser = new ObjectMapper().readValue(req.getInputStream(), User.class);

        String userName = req.getParameter("userId");
        String password = req.getParameter("password_hash");


//
      //  User user = loginService.getUserByUserName(userName);
        if(authUser == null){
            resp.setStatus(400);
            resp.getWriter().write("nothing submitted");
            return;
        }else{
            authUser = this.userService.authUser(authUser);

            if(authUser != null){
                resp.setStatus(200);
                resp.getWriter().write(new ObjectMapper().writeValueAsString(authUser));
                return;
            }
        }



        resp.setStatus(401);
        resp.getWriter().write("Email or password incoreect");


    }
}

