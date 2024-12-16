package ma.enset.conferenceservice.services;


import ma.enset.conferenceservice.entities.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);
    Review updateReview(Review review, Long id);
    void deleteReview(Long id);
    Review getReview(Long id);
    List<Review> getReviews();
}
