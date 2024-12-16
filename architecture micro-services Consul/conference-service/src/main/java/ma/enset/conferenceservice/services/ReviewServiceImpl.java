package ma.enset.conferenceservice.services;

import lombok.AllArgsConstructor;
import ma.enset.conferenceservice.entities.Review;
import ma.enset.conferenceservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    @Override
    public Review getReview(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Review review, Long id) {
        Review old = getReview(id);
        old.setDate(old.getDate());
        old.setStars(old.getStars());
        old.setTexte(old.getTexte());
        old.setConference(old.getConference());
        return reviewRepository.save(old);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }


    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
