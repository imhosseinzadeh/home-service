package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.ReviewModel;
import ir.maktab.homeserviceprovider.repository.ReviewRepository;

import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<ReviewModel, Long> {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository reviewRepository) {
        super(reviewRepository);
        this.repository = reviewRepository;
    }
}
