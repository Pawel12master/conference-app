package io.github.pawel12master.conferenceapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int size;
    private Date lecture_start;
    private Date lecture_end;
    private Date lecture_time;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lecture")
    private List<User> users = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Conference conference;

    public Lecture(int size, Date lecture_start, Date lecture_end, Date lecture_time, List<User> users, Conference conference) {
        this.size = size;
        this.lecture_start = lecture_start;
        this.lecture_end = lecture_end;
        this.lecture_time = lecture_time;
        this.users = users;
        this.conference = conference;
    }

    public Lecture() {
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

   public List<User> getUsers() {
        return users;
    }

   public void setUsers(List<User> users) {
        this.users = users;
    }

    public Conference getConference() {
        return conference;
    }

   public void setConference(Conference conference) {
        this.conference = conference;
    }

}
