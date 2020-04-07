package others;
/**
 * <h1>Message</h1>
 * <p>this class is the template of the messages</p>
 *
 * @author felix Higuera
 * @version 1.1
 * @since 2020
 * */
public class Message {

    int id_message;
    String message;
    String date;
    //attribute users
    int id_user;
    String username;

    public Message(){

    }
    /**
     * The Constructor
     * @param id_message
     * @param id_user
     * */
    public Message(int id_message, int id_user) {
        this.id_message = id_message;
        this.id_user = id_user;
    }
    /**
     * The constructor
     * @param message
     * @param id_user
     * */

    public Message(String message, int id_user) {
        this.message = message;
        this.id_user = id_user;
    }


    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
