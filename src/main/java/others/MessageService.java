package others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MessageService {
    public static void createMessage(User user){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your message");
        String mes = String.valueOf(sc.nextLine());
        Message message = new Message(mes, user.getIdUser());
        MessageDAO.createMessageDB(message);
    }
    public static void listMessage(){
        MessageDAO.listMessageDB();
    }
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
