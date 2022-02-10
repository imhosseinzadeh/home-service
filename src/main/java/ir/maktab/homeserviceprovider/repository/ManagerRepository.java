package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.model.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends UserRepository<Manager> {
}