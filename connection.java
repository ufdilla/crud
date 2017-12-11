// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.Statement;
// import java.sql.SQLException;
// import javax.swing.JOptionPane;
import java.sql.*;
import java.util.*;
/**
 * connection
//  */
// public class connection {

//     public static Connection mysqlconn;
//     public static Statement mysqlstate;

//     public static void main(String[] args) {
//         try {
//             String url = "jdbc:mysql://localhost/assignment";
//             String user = "root";
//             String passwd = "";
//             Class.forName("com.mysql.jdbc.Driver");
//             mysqlconn = DriverManager.getConnection(url,user,passwd);
//             mysqlstate = mysqlconn.createStatement();
//             System.out.println("Database Connected.");
//         } catch (Exception err) {
//             System.out.println("Connection Failed! " + err.getMessage());
//             err.printStackTrace();
//         }
//     }
// }

public class CRUD {
    // JDBC driver name and database URL
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String dbUrl = "jdbc:mysql://localhost:3306/assignment";

    // Database credentials
    static final String user = "root";
    static final String pass = "umi123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner scn = new Scanner(System.in);
        String userName = null;
        int userAge = null;

        try {
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: Open a connection
            System.out.print("\nConnecting to database...");
            conn = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println(" SUCCESS!\n");

            // STEP 4: Ask for user input
            System.out.print("Enter Your Name: ");
            userName = scn.nextLine();

            System.out.print("Enter your age: ");
            userAge = scn.nextInt();

            // STEP 5: Excute query
            System.out.print("\nInserting records into table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO users values ('', userName, userAge)";
            stmt.executeUpdate(sql);

            System.out.println(" SUCCESS!\n");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Thank you for your patronage!");
    }
}