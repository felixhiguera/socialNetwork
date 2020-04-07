package others;

/**
 * <h1>User</h1>
 * Is a template class for the Users
 *
 * @author Felix Higuera
 * @version 1.1
 * @since 2020
 * */
public class User {
    int idUser;
    String email;
    String completeName;
    String password;

    /**
     * constructor for creating and editing user
     * @param idUser parameter IdUser
     * @param email parameter email
     * @param completeName parameter for name
     * @param password parameter for password
     *
     * */
    public User(int idUser, String email, String completeName, String password) {
        this.idUser = idUser;
        this.email = email;
        this.completeName = completeName;
        this.password = password;
    }
    /**
     * constructor for deleting user
     *  @param idUser parameter IdUser
     */

    public User(int idUser) {
        this.idUser = idUser;
    }
    /**
     *constructor for bringing data of logging
     *  @param idUser parameter IdUser
     *  @param email parameter email
     *  @param completeName parameter for name
     * */
    public User(int idUser, String email, String completeName) {
        this.idUser = idUser;
        this.email = email;
        this.completeName = completeName;
    }

    public User(){

    }
    public User(String email, String password){
        this.email= email;
        this.password = password;

    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
