package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
