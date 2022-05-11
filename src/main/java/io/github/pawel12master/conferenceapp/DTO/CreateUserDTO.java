package io.github.pawel12master.conferenceapp.DTO;

public class CreateUserDTO {

    private String  email;
    private String  login;
    private String  password;
    private  int lecture_id;

    CreateUserDTO() {
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

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }
}
