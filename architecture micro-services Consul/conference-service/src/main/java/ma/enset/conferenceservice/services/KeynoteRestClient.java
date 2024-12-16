package ma.enset.conferenceservice.services;


import ma.enset.conferenceservice.models.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable Long id);

    @GetMapping("/keynotes")
    List<Keynote> getKeynotes();
}
