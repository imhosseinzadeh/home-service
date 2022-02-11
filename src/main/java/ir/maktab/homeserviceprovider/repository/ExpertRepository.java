package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.ExpertModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends UserRepository<ExpertModel> {
}
