package servlets;



import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    public void init() throws ServletException{
        loginService = new LoginService();

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
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(userName, password);

        User user = loginService.getUserByUserName(userName);
        if(result == true){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("home.jsp");

        }else{
            resp.sendRedirect("error.jsp");
        }



        if(authUser != null){
            resp.setStatus(200);
            resp.getWriter().write(new ObjectMapper().writeValueAsString(authUser));
        }

    }
}

