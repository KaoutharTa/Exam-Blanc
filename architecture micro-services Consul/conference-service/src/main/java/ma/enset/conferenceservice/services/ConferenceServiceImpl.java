package ma.enset.conferenceservice.services;

import lombok.AllArgsConstructor;
import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.repositories.ConferenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {
    private ConferenceRepository conferenceRepository;

    @Override
    public Conference getConference(Long id) {
        return conferenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Conference> getConferences() {
        return conferenceRepository.findAll();
    }

    @Override
    public Conference createConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public Conference updateConference(Conference conference, Long id) {
        Conference conf = getConference(id);
        conf.setConferenceType(conference.getConferenceType());
        conf.setDate(conference.getDate());
        conf.setNombreInscrits(conference.getNombreInscrits());
        conf.setScore(conference.getScore());
        conf.setTitre(conference.getTitre());
        return conferenceRepository.save(conf);
    }

    @Override
    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }
}
