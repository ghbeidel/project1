package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        try {
            Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Can't load jackson");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // will respond to an auth request.
        // the body must contain a user object
        // returns 200 for auth and 401 for unauth
        // 400 for unacceptable requests
        System.out.println("LOGINSERVLET");
        // get post data from request
        User authUser = new ObjectMapper().readValue(req.getInputStream(), User.class);

        if(authUser == null) {
            // not data or unparseable data
            resp.setStatus(400);
            resp.getWriter().write("No data submitted");
            return;
        } else {
            // authenticate user with database
            System.out.println("Login servlet ");
            authUser = this.userService.authUser(authUser);

            if(authUser != null) {
                // everything is good send auth data
                System.out.println("login servlet 2");
                resp.setStatus(200);
                resp.getWriter().write(new ObjectMapper().writeValueAsString(authUser));
                return;
            }
        }


        // unauthorized
        resp.setStatus(401);
        resp.getWriter().write("Email or password was incorrect");
    }
}
