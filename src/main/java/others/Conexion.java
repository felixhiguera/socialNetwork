package others;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * <h1>Conexion</h1>
 * <p>this class is for the conexion between the Social Network.java and the database red_social
 * </p>
 *
 * @author Felix Higuera
 * @version 1.1
 * @since 2020
 * */
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
