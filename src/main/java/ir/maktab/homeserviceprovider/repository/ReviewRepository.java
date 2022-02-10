package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.ReviewModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {
}
