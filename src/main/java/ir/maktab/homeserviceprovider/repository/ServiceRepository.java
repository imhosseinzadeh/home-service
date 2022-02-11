package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
