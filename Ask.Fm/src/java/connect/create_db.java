
package connect;
import java.sql.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class create_db implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
     try {
            java.sql.Statement stmt = null;
            java.sql.Statement stmt1 = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "root");
            stmt = conn.createStatement();
            stmt1 = conn.createStatement();
            sce.getServletContext().setAttribute("stmt", stmt);
            sce.getServletContext().setAttribute("stmt1", stmt1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
