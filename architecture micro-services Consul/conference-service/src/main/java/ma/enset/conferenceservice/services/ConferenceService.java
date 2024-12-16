package ma.enset.conferenceservice.services;


import ma.enset.conferenceservice.entities.Conference;

import java.util.List;

public interface ConferenceService {
    Conference getConference(Long id);

    List<Conference> getConferences();

    Conference createConference(Conference conference);

    Conference updateConference(Conference conference, Long id);

    void deleteConference(Long id);
}
