package ir.maktab.homeservice.repository.user;

import ir.maktab.homeservice.domain.model.user.ExpertModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends UserRepository<ExpertModel>, ExpertRepositoryCustom {
}
