package ir.maktab.homeservice.repository.service;

import ir.maktab.homeservice.domain.model.service.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
