package sample.Model;

public class User extends AbstractModel {
    private int id;
    private String login;
    private String password;
    private String status;

    public User(String login, String password, String status){
        this.id = -1;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public User(int id, String login, String password, String status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public User() {
        this.id = -1;
        this.login = "";
        this.password = "";
        this.status ="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
