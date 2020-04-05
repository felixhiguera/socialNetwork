package others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {
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
    public static void deleteMessageDB(Message messa){
        Conexion con = new Conexion();
        System.out.println(messa.getId_message());
        System.out.println(messa.getId_user());
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

