package ir.maktab.homeserviceprovider.service.order;

import ir.maktab.homeserviceprovider.model.order.ReviewModel;
import ir.maktab.homeserviceprovider.repository.order.ReviewRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<ReviewModel, Long> {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository reviewRepository) {
        super(reviewRepository);
        this.repository = reviewRepository;
    }
}
