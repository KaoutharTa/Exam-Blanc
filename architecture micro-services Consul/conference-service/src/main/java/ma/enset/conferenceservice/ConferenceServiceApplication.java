package ma.enset.conferenceservice;

import ma.enset.conferenceservice.entities.Conference;
import ma.enset.conferenceservice.entities.Review;
import ma.enset.conferenceservice.enums.ConferenceType;
import ma.enset.conferenceservice.services.ConferenceService;
import ma.enset.conferenceservice.services.ReviewService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ConferenceService conferenceService, ReviewService reviewService) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                int randomValue = random.nextInt(5) + 1;
                Conference conference = Conference.builder()
                        .conferenceType(Math.random() > 0.5 ? ConferenceType.COMMERCIAL : ConferenceType.ACADEMIQUE)
                        .date(new Date())
                        .duree(20 + (int) (Math.random() * (90 - 20 + 1)))
                        .nombreInscrits(2 + (int) (Math.random() * (20 - 2 + 1)))
                        .score((Math.random() * (10 + 1)))
                        .titre("Conference " + i)
                        .keynoteId(randomValue)
                        .build();

                conferenceService.createConference(conference);

                int numberOfReviews = 1 + (int) (Math.random() * 5);
                for (int j = 0; j < numberOfReviews; j++) {
                    Review review = new Review(
                            null,
                            new Date(),
                            "This is a review for conference " + i,
                            1 + (int) (Math.random() * 5),
                            conference
                    );
                    reviewService.createReview(review);
                }
            }
        };
    }


}
