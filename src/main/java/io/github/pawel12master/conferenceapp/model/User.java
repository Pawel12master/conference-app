package io.github.pawel12master.conferenceapp.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String  email;
    private String  login;
    private String  password;

    public User(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
    }
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Lecture lecture;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
