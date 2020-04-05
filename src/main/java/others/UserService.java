package others;

import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;

public class UserService {
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

    public static String cifrarMD5(String clave){
        String md5Hex = DigestUtils.md5Hex(clave);
        return md5Hex;
    }
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
    public static void listOfUsers(User usuario){
        UserDAO.listOfUsersDB(usuario);
    }
}
