package io.github.pawel12master.conferenceapp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "conference")
public class Conference {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    Date conference_start;
    Date conference_end;

    public Conference(Date conference_start, Date conference_end) {
        this.conference_start = conference_start;
        this.conference_end = conference_end;
    }
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conference")
    private List<Lecture> lectures = new ArrayList<>();

    public Conference() {
    }

    public int getId() {
        return id;
    }

    public Date getConference_start() {
        return conference_start;
    }

    public void setConference_start(Date conference_start) {
        this.conference_start = conference_start;
    }

    public Date getConference_end() {
        return conference_end;
    }

    public void setConference_end(Date conference_end) {
        this.conference_end = conference_end;
    }
}
