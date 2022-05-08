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
    Date lecture_start;
    Date lecture_end;
    Date lecture_time;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lecture")
    private List<User> users = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Conference conference;


}
