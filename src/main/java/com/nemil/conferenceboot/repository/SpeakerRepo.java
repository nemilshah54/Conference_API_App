package com.nemil.conferenceboot.repository;

import com.nemil.conferenceboot.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepo extends JpaRepository<Speaker, Long> {
}
