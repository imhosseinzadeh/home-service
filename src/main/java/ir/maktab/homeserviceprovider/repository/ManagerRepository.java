package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.ManagerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends UserRepository<ManagerModel> {
}
