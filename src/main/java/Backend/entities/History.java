package Backend.entities;

import javax.persistence.*;

@Entity
@Table(name="history")
public class History {



    int id;

    int userId;
    @Column
    String login;
    @Column
    String logout;

    @Column
    String date;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name="iduser")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
