package danrusso.U5_W1_Progetto_Settimanale.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "buildings")
public class User {
    @Id
    @Column(name = "usernames", nullable = false)
    private String username;
    @Column(name = "fullnames", nullable = false)
    private String fullname;
    @Column(name = "emails", nullable = false)
    private String email;

    public User() {
    }

    public User(String username, String fullname, String email) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
