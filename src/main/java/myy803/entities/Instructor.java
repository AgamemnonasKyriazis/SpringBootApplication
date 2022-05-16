package myy803.entities;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table (name="instructors")
public class Instructor {

    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private Integer enabled;
    @Column(name="authority")
    private String authority;


    public Instructor(String firstname, String lastname,
                      String username, String password, Integer enabled, String authority) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;
    }

    public Instructor() {
        enabled = 1;
        authority = "ROLE_INSTRUCTOR";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
