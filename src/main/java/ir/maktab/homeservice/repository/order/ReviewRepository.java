package ir.maktab.homeservice.repository.order;

import ir.maktab.homeservice.domain.model.order.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {
}
