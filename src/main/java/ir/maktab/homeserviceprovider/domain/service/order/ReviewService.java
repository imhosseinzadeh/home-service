package ir.maktab.homeserviceprovider.domain.service.order;

import ir.maktab.homeserviceprovider.domain.model.order.ReviewModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.order.ReviewDto;
import ir.maktab.homeserviceprovider.mapper.order.ReviewMapper;
import ir.maktab.homeserviceprovider.repository.order.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<ReviewModel, ReviewDto, Long> {

    private final ReviewRepository repository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository repository, ReviewMapper reviewMapper) {
        super(repository, reviewMapper);
        this.repository = repository;
        this.reviewMapper = reviewMapper;
    }
}
