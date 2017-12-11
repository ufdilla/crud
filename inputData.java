
import java.sql.*;
import java.util.*;

public class inputData 
{
    // JDBC driver name and database URL
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String dbUrl = "jdbc:mysql://localhost:3306/assignment";

    // Database
    static final String user = "root";
    static final String pass = "umi123";

    public static void main(String[] args) 
    {
        Connection conn = null;
        Statement stmt = null;
        Scanner scn = new Scanner(System.in);
        String userName = null, userGender = null;

        try 
        {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.print("\nConnecting to database...");
            conn = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println(" SUCCESS!\n");

            //user input
            System.out.print("Enter Your Name: ");
            userName = scn.nextLine();

            System.out.print("Enter your Gender: ");
            userGender = scn.nextLine();

            //Excute query
            System.out.print("\nInserting records into table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO users values ('0','" + userName + "','" + userGender + "')";
            stmt.executeUpdate(sql);

            System.out.println(" SUCCESS!\n");

        } 
        catch (SQLException se) 
        {
            se.printStackTrace();
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        
        finally 
        {
            try 
            {
                if (stmt != null)
                    conn.close();
            } 
            catch (SQLException se) 
            {

            }
            try 
            {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
        }
        
        System.out.println("Your Data was submitted.");
    }
}