package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.Manger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manger, Long> {
}