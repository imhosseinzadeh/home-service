package ir.maktab.homeservice.domain.service.order;

import ir.maktab.homeservice.domain.model.order.ReviewModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.order.ReviewDto;
import ir.maktab.homeservice.mapper.order.ReviewMapper;
import ir.maktab.homeservice.repository.order.ReviewRepository;
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
