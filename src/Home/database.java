package Home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

   public Connection c;
    public Statement s;
    public database() 
    {
        try
        {
            //Register JDBC Driver with Class's Static method
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///AirlineSystem","root","");
            s = c.createStatement();  
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println(e);
        }
    }
    
     public static void main(String[] args)
    {
        
    }
    
}
