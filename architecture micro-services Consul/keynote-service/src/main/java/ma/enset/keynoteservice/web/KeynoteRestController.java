package ma.enset.keynoteservice.web;

import lombok.AllArgsConstructor;
import ma.enset.keynoteservice.entities.Keynote;
import ma.enset.keynoteservice.service.KeynoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class KeynoteRestController {
    private KeynoteService keynoteService;

    @GetMapping("/keynotes")
    public List<Keynote> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }

    @GetMapping("/keynotes/{id}")
    public Keynote getKeynoteById(@PathVariable Long id) {
        return keynoteService.getKeynote(id);
    }

    @PostMapping("/create-keynote")
    public Keynote createKeynote(@RequestBody Keynote keynote) {
        return keynoteService.createKeynote(keynote);
    }

    @DeleteMapping("/delete-keynote/{id}")
    public void deleteKeynote(@PathVariable Long id) {
        keynoteService.deleteKeynote(id);
    }
}
