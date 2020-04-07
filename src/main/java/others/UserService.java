package others;

import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * <h1>UserService</h1>
 * This class is used for Making the process of each method like createAccount,login,editusers,listofusers
 * and the method for encrypting the password
 * @author felix higuera
 * @version 1.1
 * @since 2020
 * */
public class UserService {
    /**
     * the method createAccount makes the questions to get the data like name, email and password
     * it saves the data into the variables and call the method createAccountDB from the class UserDAO
     * */
    public static void createAccount(){

            Scanner sc = new Scanner(System.in);
            System.out.println("Give me the name");
            String name = String.valueOf(sc.nextLine());

            System.out.println("Give me the email");
            String email = String.valueOf(sc.nextLine());

            System.out.println("Give me the password");
            String password = String.valueOf(sc.nextLine());
            password = cifrarMD5(password);


            User user = new User(0,email,password,name);
            UserDAO.createAccountDB(user);

    }
    /**
     * the method login is used for logging the user, it asks the questions email and password
     * and it saves the result of the method loginDB from the class userDAO into the variable result
     * @return User the result value is returned and send it to the main class.
     *
     * */
    public static User login(){
        Scanner sc = new Scanner (System.in);

        System.out.println("give me the email");
        String email = String.valueOf(sc.nextLine());
        System.out.println("give me the password");
        String password = String.valueOf(sc.nextLine());
        password = cifrarMD5(password);
        User user = new User(email,password);
        User result =UserDAO.loginDB(user);
        return result;
    }
    /**
     * the method cifrarMD5 is maked in order to encrypt the password with DigestUtils.md5Hex
     * @param clave is a parameter that it has the value of the password asked from the method createAccount
     * @return md5Hex is returned as String (it is needed in the method createAccount from this class).
     * */
    public static String cifrarMD5(String clave){
        String md5Hex = DigestUtils.md5Hex(clave);
        return md5Hex;
    }
    /**
     * the method editUser is maked in order to change the values of the user account, it asks some questions
     * to get the new name, email, password
     * @param usuario type User and it comes from Main class
     * */
    public static void editUser(User usuario){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your complete name?");
        String name = String.valueOf(sc.nextLine());
        System.out.println("What is your email?");
        String email = String.valueOf(sc.nextLine());
        System.out.println("what is your password?");
        String pass = String.valueOf(sc.nextLine());
        pass = cifrarMD5(pass);
        User user = new User(usuario.getIdUser(),email,name,pass);

        UserDAO.editUserDB(user);
    }
    /**
     * the method listOfUsers makes the call to the ListOfUsersDB from the UserDAO class
     * @param usuario type User and it comes from the method menuSession in the Main class
     * */
    public static void listOfUsers(User usuario){
        UserDAO.listOfUsersDB(usuario);
    }
}
