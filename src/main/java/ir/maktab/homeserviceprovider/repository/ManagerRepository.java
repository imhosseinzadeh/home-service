package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}