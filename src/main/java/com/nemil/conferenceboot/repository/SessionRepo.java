package com.nemil.conferenceboot.repository;

import com.nemil.conferenceboot.models.Session;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
@Service
@ComponentScan
@Component
public interface SessionRepo extends JpaRepository<Session, Long> {
}
