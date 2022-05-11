package io.github.pawel12master.conferenceapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface SqlConferenceRepository extends  JpaRepository<Conference, Integer> {

}
