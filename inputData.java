import java.sql.*;
import java.util.*;

public class inputData 
{
    
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String dbUrl = "jdbc:mysql://localhost:3306/assignment";

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
    
            Class.forName("com.mysql.jdbc.Driver");

            System.out.print("\nConnecting to database...");
            conn = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println(" SUCCESS!\n");

            System.out.print("Enter Your Name: ");
            userName = scn.nextLine();

            System.out.print("Enter your Gender: ");
            userGender = scn.nextLine();

            System.out.print("\nInserting records into table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO users values ('0','" + userName + "','" + userGender + "')";
            stmt.executeUpdate(sql);

            String upd = "Update users set gender='perempuan' where userid=3";
            stmt.executeUpdate(upd);

            String del = "delete from users where userid = 4";
            stmt.executeUpdate(del);

            System.out.println(" SUCCESS!\n");
            System.out.println("Your Data was submitted.");

            String result = "select*from users";
            // System.out.println(stmt.executeQuery(result));
            ResultSet rs = stmt.executeQuery(result);
            while (rs.next()) {
                int userid = rs.getInt("userid");
                String nama = rs.getString("name");
                String gender = rs.getString("gender");
                System.out.println(userid + "\t" + nama + "\t" + gender);
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }
}