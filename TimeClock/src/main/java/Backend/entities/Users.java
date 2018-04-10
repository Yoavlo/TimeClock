package Backend.entities;
import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {



    int idUser;
    @Column
    String user;
    @Column
    String email;
    @Column
    String password;
    Boolean isAdmin;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "admin")
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
