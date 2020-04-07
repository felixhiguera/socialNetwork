package others;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * <h1>UserDAO</h1>
 * Class for making the request to the database, it contains the methods createAccountDB, loginDB, editUserDB, listOfUsersDB
 *
 * @author Felix Higuera
 * @version 1.1
 * @since 2020
 * */
public class UserDAO {
    /**
     * method createAccountDB makes the request for creating an account with the query
     * @param user type User from the method class createAccount in the class userService
     *
     * */

    public static void createAccountDB(User user){

        Conexion con = new Conexion ();
      try ( Connection cone = con.get_connection()){
          PreparedStatement ps= null;
          try {
              String query = "insert into usuarios(correo,clave,nombre_completo) values (?,?,?)";
              ps = cone.prepareStatement(query);
              ps.setString(1, user.getEmail());
              ps.setString(2, user.getPassword());
              ps.setString(3, user.getCompleteName());
              ps.executeUpdate();
              System.out.println("\n user created, you can use your account\n");
          }catch(SQLException e){
              System.out.println("It could not be created");
          }
      }catch(SQLException ex){
          System.out.println(ex);
      }

    /** method loginDB makes the request to the DB for loggin with the account
     * if the user and password are correct, it will print "logged
     * else it will print login failed
     * @param user type User bring fom the method login from the class UserService
     * @return User it returns an object type User for sending to the method menuSession in the main class
     * */
    }
    public static User loginDB(User user){
        Conexion con = new Conexion ();
        try (Connection cone = con.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "select * from usuarios where correo=? and clave= ?";
            ps = cone.prepareStatement(query);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getPassword());
            rs= ps.executeQuery();
            User login = new User();
            if(rs.next()) {
                System.out.println("Logged");
                login.setIdUser(rs.getInt("id_usuario"));
                login.setEmail(rs.getString("correo"));
                login.setCompleteName(rs.getString("nombre_completo"));
            }else {
                System.out.println("login failed");
            }
                return login;
            }catch(SQLException e){
            System.out.println("\n it was not possible to authenticate with the server");
        }catch(Exception ex){
            System.out.println(ex);
        }
            return null;
    }
    /**
     * the method editUserDB edit the values of the user account and send the request to the DB
     * @param user type User bring from the editUser in the class UserService
     * */
    public static void editUserDB(User user){
        Conexion con = new Conexion ();

        try(Connection cone = con.get_connection()){
            PreparedStatement ps;
            try{
                String query = "update usuarios set correo = ?, clave = ?, nombre_completo = ? where id_usuario = ?";
                ps = cone.prepareStatement(query);
                ps.setString(1,user.getEmail());
                ps.setString(2,user.getPassword());
                ps.setString(3,user.getCompleteName());
                ps.setInt(4,user.getIdUser());
                ps.executeUpdate();
                System.out.println("the details has been updated");
            }catch(SQLException ex){
                System.out.println("the details did not update");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**
     * the method listOfUsersDB print the of users from the db
     * @param usuario type User is from the method listOfUsers from the class UserService
     * */
    public static void listOfUsersDB(User usuario){
        Conexion con = new Conexion ();
        try(Connection cone = con.get_connection()){
            PreparedStatement ps;
            ResultSet rs;
            try{
                String query ="select * from usuarios";
                ps = cone.prepareStatement(query);
                rs=ps.executeQuery();
                while(rs.next()){
                    System.out.println("\n[ID: " + rs.getInt("id_usuario") + " | ");
                    System.out.println("Correo: " + rs.getString("correo") + " | ");
                    System.out.println("Nombre completo " + rs.getString("nombre_completo") + " ' ");
                }
            }catch(SQLException e){
                System.out.println("it is not possible to see the list of users");

            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
