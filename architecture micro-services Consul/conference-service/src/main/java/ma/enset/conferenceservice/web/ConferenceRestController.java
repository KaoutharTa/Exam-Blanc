package ma.enset.conferenceservice.web;

import lombok.AllArgsConstructor;
import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.services.ConferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ConferenceRestController {
    private ConferenceService service;

    @GetMapping("/conferences")
    public List<Conference> getConferences() {
        return service.getConferences();
    }

    @GetMapping("/conferences/{id}")
    public Conference getConference(@PathVariable Long id) {
        return service.getConference(id);
    }

    @PostMapping("/create-conference")
    public Conference createConference(@RequestBody Conference conference) {
        return service.createConference(conference);
    }

    @DeleteMapping("/delete-conference/{id}")
    public void deleteConference(@PathVariable Long id) {
        service.deleteConference(id);
    }
}
