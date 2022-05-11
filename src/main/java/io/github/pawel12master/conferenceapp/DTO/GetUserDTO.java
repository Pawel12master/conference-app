package io.github.pawel12master.conferenceapp.DTO;

import io.github.pawel12master.conferenceapp.model.Lecture;

public class GetUserDTO {
    private int id;
    private String  email;
    private String  login;
    private String  password;
    private GetLectureDTO getLectureDTO;

    public GetUserDTO(int id, String email, String login, String password, GetLectureDTO getLectureDTO) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.password = password;
        this.getLectureDTO = getLectureDTO;
    }

    public GetLectureDTO getGetLectureDTO() {
        return getLectureDTO;
    }

    public void setGetLectureDTO(GetLectureDTO getLectureDTO) {
        this.getLectureDTO = getLectureDTO;
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
