package main;

import others.Message;
import others.MessageService;
import others.User;
import others.UserService;

import java.util.Scanner;
/**
 * <h1>Main</h1>
 * <p>
 *     It visualize the main menu of the program<br>
 *         the user can visualize the options Signup, Login and Exit.<br>
 *             also it has the submenu write a message, list the messages,etc.
 * </p>
 *
 * @author Felix Higuera
 * @version 1.1
 * @since 2020
 * */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int response = 0;
        do{
            System.out.println("Welcome to the social network");
            System.out.println("1.Sign up");
            System.out.println("2.Log in");
            System.out.println("3.Exit");
            response = Integer.valueOf(sc.nextInt());

            switch(response){
                case 1:
                    UserService.createAccount();
                    break;
                case 2:
                    User result = UserService.login();
                    if(result.getIdUser()>0){
                        menuSession(result);
                    }
                    else{
                        System.out.println("it is not possible");
                    }
                    break;
                default:
                    break;
            }
        }while (response !=3);
    }
    public static void menuSession(User usuario){
        int response=0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(usuario.getIdUser());
            System.out.println(usuario.getCompleteName());
            System.out.println("1.Write a message");
            System.out.println("2.list a message");
            System.out.println("3.Delete a message");
            System.out.println("4.Edit Users");
            System.out.println("5.list of Users");
            System.out.println("6.Cerrar Sesion");


            response = Integer.valueOf(sc.nextInt());

            switch(response){
                case 1:
                    MessageService.createMessage(usuario);
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.deleteMessage(usuario);
                    break;
                case 4:
                    UserService.editUser(usuario);
                    break;
                case 5:
                    UserService.listOfUsers(usuario);
                    break;
                default:
                    break;
            }

        }while(response !=6);
    }

}
