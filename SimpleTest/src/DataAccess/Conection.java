package DataAccess;

/**
 *
 * @author Diego
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conection {
    public static Connection connection;
    public static Connection connect(){
    String url = "jdbc:postgresql://localhost/testproyecto";
    String user = "diegoroot";
    String pass = "root";
    System.out.println("Conectando...");
    try{
         connection = DriverManager.getConnection(url, user,pass);
    
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return connection;
    }
    
}
