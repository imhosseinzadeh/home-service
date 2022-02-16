package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.model.user.ManagerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends UserRepository<ManagerModel> {
}
