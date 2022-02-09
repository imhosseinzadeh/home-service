package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
