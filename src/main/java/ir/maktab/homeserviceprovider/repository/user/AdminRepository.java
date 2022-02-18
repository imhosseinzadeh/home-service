package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.model.user.AdminModel;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends UserRepository<AdminModel> {
}
