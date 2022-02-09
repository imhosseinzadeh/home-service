package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends UserRepository<Manager> {
}