package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.ReviewModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.ReviewDto;
import ir.maktab.homeserviceprovider.repository.order.ReviewRepository;
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

    @Override
    protected Class<ReviewDto> getDtoClass() {
        return ReviewDto.class;
    }

}
