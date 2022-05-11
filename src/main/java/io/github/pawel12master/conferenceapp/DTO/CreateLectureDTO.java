package io.github.pawel12master.conferenceapp.DTO;

import java.util.Date;

public class CreateLectureDTO {
    private int size;
    private Date lecture_start;
    private Date lecture_end;
    private Date lecture_time;
    private int conference_id;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getLecture_start() {
        return lecture_start;
    }

    public void setLecture_start(Date lecture_start) {
        this.lecture_start = lecture_start;
    }

    public Date getLecture_end() {
        return lecture_end;
    }

    public void setLecture_end(Date lecture_end) {
        this.lecture_end = lecture_end;
    }

    public Date getLecture_time() {
        return lecture_time;
    }

    public void setLecture_time(Date lecture_time) {
        this.lecture_time = lecture_time;
    }

    public int getConference_id() {
        return conference_id;
    }

    public void setConference_id(int conference_id) {
        this.conference_id = conference_id;
    }
}
