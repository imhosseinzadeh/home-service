package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.Review;
import ir.maktab.homeserviceprovider.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<Review, Long> {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository reviewRepository) {
        super(reviewRepository);
        this.repository = reviewRepository;
    }
}
