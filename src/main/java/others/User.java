package others;

public class User {
    int idUser;
    String email;
    String completeName;
    String password;

    public User(int idUser, String email, String completeName, String password) {
        this.idUser = idUser;
        this.email = email;
        this.completeName = completeName;
        this.password = password;
    }

    public User(int idUser) {
        this.idUser = idUser;
    }

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
