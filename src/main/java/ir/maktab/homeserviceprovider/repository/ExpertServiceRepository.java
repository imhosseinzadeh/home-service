package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.ExpertService;
import ir.maktab.homeserviceprovider.entity.ExpertServiceId;
import ir.maktab.homeserviceprovider.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertServiceRepository extends JpaRepository<ExpertService, ExpertServiceId> {

    Page<ExpertService> findAllByService(Service service, Pageable pageable);
}