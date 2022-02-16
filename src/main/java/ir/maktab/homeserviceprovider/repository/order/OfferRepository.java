package ir.maktab.homeserviceprovider.repository.order;

import ir.maktab.homeserviceprovider.model.order.OfferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferModel, Long> {
}
