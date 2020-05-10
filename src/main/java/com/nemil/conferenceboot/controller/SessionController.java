package com.nemil.conferenceboot.controller;

import com.nemil.conferenceboot.models.Session;
import com.nemil.conferenceboot.repository.SessionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired(required = true)
    private SessionRepo sessionRepo;

    @GetMapping
    public List<Session> list(){
        return sessionRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{{id}}")
    public Session getById(@PathVariable Long id){
        return sessionRepo.getOne(id);
    }

    @PostMapping
    public Session createSession(@RequestBody Session session){
        return sessionRepo.saveAndFlush(session);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id){
        sessionRepo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session updateSession(@PathVariable Long id, Session session){
        Session existingSession = sessionRepo.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepo.saveAndFlush(existingSession);
    }
}
