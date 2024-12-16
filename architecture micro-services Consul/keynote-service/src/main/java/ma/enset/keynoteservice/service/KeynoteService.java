package ma.enset.keynoteservice.service;

import ma.enset.keynoteservice.entities.Keynote;

import java.util.List;

public interface KeynoteService {
    Keynote getKeynote(Long id);
    Keynote createKeynote(Keynote keynote);
    Keynote updateKeynote(Long id, Keynote keynote);
    void deleteKeynote(Long id);
    List<Keynote> getAllKeynotes();
}
