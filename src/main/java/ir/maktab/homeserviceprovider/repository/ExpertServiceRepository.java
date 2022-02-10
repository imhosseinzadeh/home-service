package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.ExpertService;
import ir.maktab.homeserviceprovider.model.ExpertServiceId;
import ir.maktab.homeserviceprovider.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertServiceRepository extends JpaRepository<ExpertService, ExpertServiceId> {

    Page<ExpertService> findAllByService(Service service, Pageable pageable);
}