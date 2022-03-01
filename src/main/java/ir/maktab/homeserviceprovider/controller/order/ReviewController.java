package ir.maktab.homeserviceprovider.controller.order;

import ir.maktab.homeserviceprovider.domain.service.order.ReviewService;
import ir.maktab.homeserviceprovider.dto.order.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping("/submit")
    public ResponseEntity<ReviewDto> submit(@RequestBody @Valid ReviewDto reviewDto) {
        ReviewDto saved = this.service.save(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
