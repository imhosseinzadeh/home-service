package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.OfferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferModel, Long> {
}
