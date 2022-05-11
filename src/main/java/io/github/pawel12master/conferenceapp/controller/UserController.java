package io.github.pawel12master.conferenceapp.controller;

import io.github.pawel12master.conferenceapp.DTO.CreateUserDTO;
import io.github.pawel12master.conferenceapp.DTO.GetLectureDTO;
import io.github.pawel12master.conferenceapp.DTO.GetUserDTO;
import io.github.pawel12master.conferenceapp.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(ConferenceController.class);
    private final SqlUserRepository sqlUserRepository;
    private final SqlLectureRepository sqlLectureRepository;

    public UserController(SqlUserRepository sqlUserRepository, SqlLectureRepository sqlLectureRepository) {
        this.sqlUserRepository = sqlUserRepository;
        this.sqlLectureRepository = sqlLectureRepository;
    }
    @GetMapping(value = "/users", params = {"!sort","!page","!size"})
    ResponseEntity<List<GetUserDTO>> readAll(){
        logger.warn("all users");
        return ResponseEntity.ok(sqlUserRepository.findAll().stream().map(user -> new GetUserDTO(user.getId(),user.getEmail(), user.getLogin(), user.getPassword(),new GetLectureDTO(user.getLecture().getId(),user.getLecture().getSize(),new Date(),new Date(),new Date()))).collect(Collectors.toList()));
    }
    @PostMapping("/users")
    ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDTO toCreate){
        User user = new User();
        user.setEmail(toCreate.getEmail());
        user.setLogin(toCreate.getLogin());
        user.setPassword(toCreate.getPassword());
        user.setLecture(sqlLectureRepository.findById(toCreate.getLecture_id())
                .orElseThrow());
        user = sqlUserRepository.save(user);
        return ResponseEntity.created(URI.create(""+user.getId())).body(user);
    }
}
