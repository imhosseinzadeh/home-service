package ir.maktab.homeservice.repository.service;

import ir.maktab.homeservice.domain.model.service.ExpertServiceModel;
import ir.maktab.homeservice.domain.model.service.ExpertServiceModelId;
import ir.maktab.homeservice.domain.model.service.ServiceModel;
import ir.maktab.homeservice.domain.model.user.ExpertModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertServiceRepository extends JpaRepository<ExpertServiceModel, ExpertServiceModelId> {
    Page<ExpertServiceModel> findAllByService(ServiceModel service, Pageable pageable);

    Page<ExpertServiceModel> findAllByExpert(ExpertModel expert, Pageable pageable);

}
