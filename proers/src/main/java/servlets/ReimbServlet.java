//package servlets;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import data.ReimbDao;
//import entities.Reimb;
//import entities.User;
//import services.ReimbService;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//public class ReimbServlet extends HttpServlet {
//        private ReimbService reimbService;
//
//    public void init() throws ServletException{
//        reimbService = new ReimbService();
//
//        try{
//            Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
//        }catch(ClassNotFoundException c){
//            throw new ServletException("Cant load jackson");
//        }
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       // List<Reimb> retrieve = new ObjectMapper().readValue(req.getInputStream(), Reimb.class);
//        User u = new ObjectMapper().readValue(req.getInputStream(), User.class);
//        if(retrieve == null){
//            resp.setStatus(400);
//            resp.getWriter().write("Not data found");
//            return;
//        }else{
//            retrieve = this.reimbService.getAllReimbs(u);
//        }
//
//
//
//    }
//}
