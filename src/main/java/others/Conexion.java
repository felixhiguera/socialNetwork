package others;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection get_connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/red_social","root","");
        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
