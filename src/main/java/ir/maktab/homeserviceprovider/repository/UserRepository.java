package ir.maktab.homeserviceprovider.repository;

import ir.maktab.homeserviceprovider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<U extends User> extends JpaRepository<U, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE #{#entityName} u SET u.password= :password WHERE u.id= :id")
    void updatePasswordById(Long id, String password);
}
