package others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
/**
 * <h1>Message Service</h1>
 * <p>this class contains the methods createMessage, listMessage and deleteMessage</p>
 *
 * @author Felix Higuera
 * @version 1.1
 * @since 2020
 * */
public class MessageService {
    /**
     * <h1>CreateMessage</h1>
     * this method is created to ask "what is the message" and save the answer and send to the method MessageDAO.createMessageDB
     *
     * @param user this variable is type User and it cames from the Main class when the user press 1 to create a message
     *
     * */
    public static void createMessage(User user){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your message");
        String mes = String.valueOf(sc.nextLine());
        Message message = new Message(mes, user.getIdUser());
        MessageDAO.createMessageDB(message);
    }
    /**
     * <h1>listMessage</h1>
     * this method is for making a list of messages, it calls the method listMessageDB from the class MessageDAO
     * */
    public static void listMessage(){
        MessageDAO.listMessageDB();
    }
    /**
     * <h1>deleteMessage</h1>
     * this method is for deleting message, it ask the ID of the message and it saves the variable and send
     * into the method deleteMessageDB as parameter from the class MessageDAO
     *
     * @param user this variable is type User and it cames from the Main class when the user press 1 to create a message
     * */
    public static void deleteMessage(User user){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the id of the message");
        int idmessage = Integer.valueOf(sc.nextInt());
        Message messa = new Message(idmessage,user.getIdUser());
        System.out.println(idmessage);
        System.out.println(user.getIdUser());
        MessageDAO.deleteMessageDB(messa);
    }
}
