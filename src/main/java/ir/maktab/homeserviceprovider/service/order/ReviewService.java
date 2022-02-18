package ir.maktab.homeserviceprovider.service.order;

import ir.maktab.homeserviceprovider.dto.order.ReviewDto;
import ir.maktab.homeserviceprovider.model.order.ReviewModel;
import ir.maktab.homeserviceprovider.repository.order.ReviewRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<ReviewModel, ReviewDto, Long> {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository reviewRepository) {
        super(reviewRepository);
        this.repository = reviewRepository;
    }

    @Override
    protected Class<ReviewModel> getModelClass() {
        return ReviewModel.class;
    }

}
