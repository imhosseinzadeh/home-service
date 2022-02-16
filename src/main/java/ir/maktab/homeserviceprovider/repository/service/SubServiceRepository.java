package ir.maktab.homeserviceprovider.repository.service;

import ir.maktab.homeserviceprovider.model.service.SubServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubServiceRepository extends JpaRepository<SubServiceModel, Long> {
}
