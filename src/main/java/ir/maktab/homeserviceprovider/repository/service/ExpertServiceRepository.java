package ir.maktab.homeserviceprovider.repository.service;

import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModel;
import ir.maktab.homeserviceprovider.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeserviceprovider.domain.model.service.ServiceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertServiceRepository extends JpaRepository<ExpertServiceModel, ExpertServiceModelId> {
    Page<ExpertServiceModel> findAllByService(ServiceModel service, Pageable pageable);
}
