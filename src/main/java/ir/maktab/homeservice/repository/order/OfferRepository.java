package ir.maktab.homeservice.repository.order;

import ir.maktab.homeservice.domain.model.order.OfferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferModel, Long> {
}
