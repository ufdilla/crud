import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * connection
 */
public class connection {

    public static Connection mysqlconn;

    public static Connection dbconn() throws SQLException{

        if(mysqlconn==null) {
            
            try {
                String DB="jdbc:mysql://localhost:3306/assignment"; // database
                String user="root"; // user database
                String pass=""; // password database
                // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlconn = (Connection) DriverManager.getConnection(DB,user,pass);
            }
            catch (Exception err){
                JOptionPane.showMessageDialog(null, "Connection Failed!");
            }
        }

        return mysqlconn;
    }
}