package io.github.pawel12master.conferenceapp.controller;

import io.github.pawel12master.conferenceapp.DTO.CreateLectureDTO;
import io.github.pawel12master.conferenceapp.model.Conference;
import io.github.pawel12master.conferenceapp.model.Lecture;
import io.github.pawel12master.conferenceapp.model.SqlConferenceRepository;
import io.github.pawel12master.conferenceapp.model.SqlLectureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class LectureController {
    private static final Logger logger = LoggerFactory.getLogger(ConferenceController.class);
    private final SqlLectureRepository sqlLectureRepository;
    private final SqlConferenceRepository sqlConferenceRepository;

    public LectureController(SqlLectureRepository sqlLectureRepository, SqlConferenceRepository sqlConferenceRepository) {
        this.sqlLectureRepository = sqlLectureRepository;
        this.sqlConferenceRepository = sqlConferenceRepository;
    }
    @GetMapping(value = "/lectures", params = {"!sort","!page","!size"})
    ResponseEntity<List<Lecture>> readAll(){
        logger.warn("all conference");
        return ResponseEntity.ok(sqlLectureRepository.findAll());
    }
    @PostMapping("/lectures")
    ResponseEntity<Lecture> createLecture(@RequestBody @Valid CreateLectureDTO toCreate){
        Lecture lecture = new Lecture();
        lecture.setConference(sqlConferenceRepository.findById(toCreate.getConference_id()).orElseThrow());
        lecture.setSize(toCreate.getSize());
        Lecture result = sqlLectureRepository.save(lecture);
        return ResponseEntity.created(URI.create(""+result.getId())).body(result);
    }
}
