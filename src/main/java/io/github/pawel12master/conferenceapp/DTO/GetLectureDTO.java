package io.github.pawel12master.conferenceapp.DTO;

import java.util.Date;

public class GetLectureDTO {
    private int id;
    private int size;
    private Date lecture_start;
    private Date lecture_end;
    private Date lecture_time;

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



    public GetLectureDTO(int id, int size, Date lecture_start, Date lecture_end, Date lecture_time  ) {
        this.id = id;
        this.size = size;
        this.lecture_start = lecture_start;
        this.lecture_end = lecture_end;
        this.lecture_time = lecture_time;

    }


}
