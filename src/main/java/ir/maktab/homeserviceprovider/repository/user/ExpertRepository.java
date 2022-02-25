package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends UserRepository<ExpertModel>, ExpertRepositoryCustom {
}
