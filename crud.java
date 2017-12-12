import java.sql.*;
import java.util.*;
// import com.mysql.jdbc.Driver;

/**
 * crud
 */
public class crud {

    public static void main(String[] args) throws SQLException{
        try {
            String url = "jdbc:mysql://localhost:3306/assignment";
            String user = "root";
            String passwd = "umi123";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Database Connected.");

            Statement state = conn.createStatement();
            int data = state.executeUpdate("insert into users values(,'Lani','laki-laki')");
            System.out.println("Data inserted = " + data);

            data = state.executeUpdate("Update users set gender='perempuan' where userid=3");
            System.out.println("data updated = " + data);

            ResultSet rs = state.executeQuery("Select * from users");
            while (rs.next()) {
                System.out.println("User Id : " + rs.getInt("userid") + ", Nama : " + rs.getString("name")
                        + ", Gender : " + rs.getString("gender"));
            }

            data = state.executeUpdate("delete from users where userid = 4");
            System.out.println("data deleted = " + data);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }    
}