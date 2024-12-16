package ma.enset.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.conferenceservice.enums.ConferenceType;
import ma.enset.conferenceservice.models.Keynote;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Enumerated(EnumType.STRING)
    private ConferenceType conferenceType;

    private Date date;
    private Integer duree;
    private Integer nombreInscrits;
    private Double score;
    private Integer keynoteId;
    @Transient
    private Keynote keynote;
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
