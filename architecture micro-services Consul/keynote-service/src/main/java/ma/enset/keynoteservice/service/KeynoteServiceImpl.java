package ma.enset.keynoteservice.service;

import lombok.AllArgsConstructor;
import ma.enset.keynoteservice.entities.Keynote;
import ma.enset.keynoteservice.repositories.KeynoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {
    private KeynoteRepository keynoteRepository;

    @Override
    public Keynote getKeynote(Long id) {
        return keynoteRepository.findById(id).orElse(null);
    }

    @Override
    public Keynote createKeynote(Keynote keynote) {
        return keynoteRepository.save(keynote);
    }

    @Override
    public Keynote updateKeynote(Long id, Keynote keynote) {
        Keynote old = getKeynote(id);
        old.setEmail(keynote.getEmail());
        old.setFonction(keynote.getFonction());
        old.setNom(keynote.getNom());
        old.setPrenom(keynote.getPrenom());
        return keynoteRepository.save(old);
    }

    @Override
    public void deleteKeynote(Long id) {
        keynoteRepository.deleteById(id);
    }

    @Override
    public List<Keynote> getAllKeynotes() {
        return keynoteRepository.findAll();
    }
}
