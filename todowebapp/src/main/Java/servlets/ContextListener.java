package servlets;



import util.ConnectionUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.SQLException;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("Initialize application context");
        ServletContext context = sce.getServletContext();
        String url = context.getInitParameter("dbUrl");
        String username = context.getInitParameter("dbUsername");
        String password = context.getInitParameter("dbPassword");
        String dbDriverName = context.getInitParameter("dbDriver");
        Driver driver;
        try{
            driver = (Driver) Class.forName(dbDriverName).newInstance();
            ConnectionUtil.createConnectionManager(url,username,password,driver);

        }catch (InstantiationException e){
            throw new IllegalStateException("couldnt ot init db driver");
        }catch (IllegalAccessException e){
            throw new IllegalStateException("couldnt init db driver");
        }catch(ClassNotFoundException c){
            throw new IllegalStateException("could not init db driver ");
        }catch(SQLException e){
            throw new IllegalStateException("something lower than init connection manger ");
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){

    }
}
