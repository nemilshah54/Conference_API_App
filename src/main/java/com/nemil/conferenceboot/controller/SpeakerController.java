package com.nemil.conferenceboot.controller;

import com.nemil.conferenceboot.models.Speaker;
import com.nemil.conferenceboot.repository.SpeakerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepo speakerRepo;

    @GetMapping
    public List<Speaker> speakerList(){
        return speakerRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{{id}}")
    public Speaker getSpeakerById(@PathVariable Long id){
        return speakerRepo.getOne(id);
    }

    @PostMapping
    public Speaker createSpeaker (@RequestBody Speaker speaker){
        return speakerRepo.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSpeaker(@PathVariable Long id){
        // Check for children records before deleting. (Cascades)
        speakerRepo.deleteById(id);
    }

    @RequestMapping(value= "{id}", method = RequestMethod.PUT)
    public Speaker updateSpeaker(@RequestBody final Speaker speaker, @PathVariable Long id){
        // Put replaces all attributes. Patch replaces partial attributes.
        Speaker existingSpeaker = speakerRepo.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepo.saveAndFlush(existingSpeaker);
    }
}
