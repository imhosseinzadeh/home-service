package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
}