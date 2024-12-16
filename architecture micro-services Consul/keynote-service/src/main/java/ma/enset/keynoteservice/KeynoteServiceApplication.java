package ma.enset.keynoteservice;

import ma.enset.keynoteservice.entities.Keynote;
import ma.enset.keynoteservice.service.KeynoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KeynoteService keynoteService) {
        return args -> {
            for (int i = 0; i < 5; i++) {
                keynoteService.createKeynote(Keynote.builder()
                        .email("email" + i + "@gmail.com")
                        .fonction(Math.random() > 0.5 ? "Plumber" : "Electrician")
                        .nom("keynote nom " + i)
                        .prenom("keynote prenom " + i)
                        .build());
            }
        };
    }

}
