package io.github.pawel12master.conferenceapp.controller;

import io.github.pawel12master.conferenceapp.model.Conference;
import io.github.pawel12master.conferenceapp.model.SqlConferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
 class ConferenceController {
    private static final Logger logger = LoggerFactory.getLogger(ConferenceController.class);
    private final SqlConferenceRepository sqlConferenceRepository;


    ConferenceController( final SqlConferenceRepository sqlConferenceRepository) {
        this.sqlConferenceRepository = sqlConferenceRepository;
    }
    @PostMapping("/conferences")
    ResponseEntity<Conference> createConference(@RequestBody @Valid Conference toCreate){
        Conference result = sqlConferenceRepository.save(toCreate);
        return ResponseEntity.created(URI.create(""+result.getId())).body(result);
    }

    @GetMapping(value = "/conferences", params = {"!sort","!page","!size"})
    ResponseEntity<List<Conference>> readAll(){
        logger.warn("all conference");
        return ResponseEntity.ok(sqlConferenceRepository.findAll());
    }
    @PutMapping("/conferences/{id}")
    ResponseEntity<?> updateConference(@PathVariable int id, @RequestBody Conference toUpdate){
        if (!sqlConferenceRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        sqlConferenceRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/conferences/{id}")
    ResponseEntity<Conference> readConference(@PathVariable int id){
        return sqlConferenceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/conferences/{id}")
    ResponseEntity<Void> deleteConference(@PathVariable int id){
        sqlConferenceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}


