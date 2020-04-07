package others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * <h1>Message DAO</h1>
 * <p>
 *     This class send the request made it in the program to the database
 * </p>
 *
 * @author Felix Higuera
 * @version 1.1
 * @since 2020
 * */
public class MessageDAO {



    /**
     * <h1>createMessageDB</h1>
     * <p>this method is for creating a message and send the request to the database</p>
     *
     * @param message It is the message receive it from the class MessageService.createMessage()
     * */
    public static void createMessageDB(Message message) {
        Conexion con = new Conexion();
        try (Connection cone = con.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "insert into mensajes(id_usuario,mensaje,fecha) values (?,?,CURRENT_TIMESTAMP)";
                ps = cone.prepareStatement(query);

                ps.setInt(1, message.getId_user());
                ps.setString(2, message.getMessage());
                ps.executeUpdate();
                System.out.println("\n Message created \n");
            } catch (SQLException e) {
                System.out.println("Message not created");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * <h1>listMessageDB</h1>
     * <p>this method show the list of messages from the user, this class is called from the MessageService.ListMessage()</p>
     * */

    public static void listMessageDB() {
        Conexion con = new Conexion();
        try (Connection cone = con.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "select m.id_mensaje,m.mensaje,m.fecha,u.nombre_completo from mensajes m join usuarios u on m.id_usuario=u.id_usuario";
                ps = cone.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("\n[id: " + rs.getInt("id_mensaje") + " |");
                    System.out.println("message: " + rs.getString("mensaje") + " |");
                    System.out.println("Date " + rs.getString("fecha") + " |");
                    System.out.println("Author " + rs.getString("nombre_completo"));
                }

            } catch (SQLException ex) {
                System.out.println("\n it could not list the messages\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * <h1>deleteMessageDB</h1>
     * <p>this method is for deleting a message in the user logged and send the request to the database</p>
     *
     * @param messa It is the message receive it from the class MessageService.deleteMessage()
     * */
    public static void deleteMessageDB(Message messa){
        //it creates a object type Conexion
        Conexion con = new Conexion();
        //it calls the conexion to the database and save in the object cone (type Connection)
        try(Connection cone = con.get_connection()) {

            PreparedStatement ps = null;
            try {
                String query = "delete from mensajes where id_mensaje = ? and id_usuario = ?";
                ps = cone.prepareStatement(query);
                ps.setInt(1, messa.getId_message());
                ps.setInt(2, messa.getId_user());


                ps.executeUpdate();
                System.out.println("\n Message deleted \n");

            } catch (SQLException ex) {
                System.out.println("The message could not be deleted");
            }
        }catch(Exception e){
            System.out.println(e);

            }
        }

    }

