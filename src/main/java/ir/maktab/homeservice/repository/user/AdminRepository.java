package ir.maktab.homeservice.repository.user;

import ir.maktab.homeservice.domain.model.user.AdminModel;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends UserRepository<AdminModel> {
}
