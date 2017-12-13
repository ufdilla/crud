import java.sql.*;
import java.util.*;

public class inputData 
{
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String dbUrl = "jdbc:mysql://localhost:3306/assignment";
    static final String user = "root";
    static final String pass = "umi123";

    public static void main (String[] args) 
    {
        Connection conn = null;
        Statement statement1 = null;
        Scanner scan1 = new Scanner (System.in);
        String userName = null, userGender = null, userId;

        try 
        {   // java data base connector
            Class.forName ("com.mysql.jdbc.Driver");
            System.out.print ("\nConnecting to database...");
            conn = DriverManager.getConnection (dbUrl, user, pass);
            System.out.println (" SUCCESS!\n");
            
            // create
            System.out.print ("Enter Your Name: ");
            userName = scan1.nextLine ();
            System.out.print ("Enter your Gender: ");
            userGender = scan1.nextLine ();
            statement1 = conn.createStatement ();
            String sql = "INSERT INTO users values ('0','" + userName + "','" + userGender + "')";
            statement1.executeUpdate (sql);
            
            // read
            String result = "select*from users";
            ResultSet table1 = statement1.executeQuery (result);
            while (table1.next ()) 
            {
                int userid = table1.getInt ("userid");
                String nama = table1.getString ("name");
                String gender = table1.getString ("gender");
                System.out.println (userid + "\t" + nama + "\t" + gender);
            }
        
            // update
            System.out.print ("\nEnter Name to Update: ");
            userName = scan1.nextLine ();
            System.out.print ("Enter User Id to Set Update: ");
            userId = scan1.nextLine ();
            String upd = "Update users set name='"+ userName +"' where userid="+ userId +"";
            statement1.executeUpdate (upd);
            
            // delete
            System.out.print ("\nEnter User Id to Set Delete: ");
            userId = scan1.nextLine ();
            String del = "delete from users where userid = "+ userId +"";
            statement1.executeUpdate (del);
            System.out.println (" SUCCESS!\n");
            System.out.println ("Your Data was submitted.");

        }

        catch (Exception e) 
        { e.printStackTrace (); }
    }
}
