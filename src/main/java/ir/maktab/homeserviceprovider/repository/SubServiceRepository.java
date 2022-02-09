package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Long> {
}
