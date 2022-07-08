package ir.maktab.homeservice.repository.user;

import ir.maktab.homeservice.domain.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<U extends UserModel> extends JpaRepository<U, Long>,
        JpaSpecificationExecutor<U> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE #{#entityName} u SET u.password= :password WHERE u.id= :id")
    void updatePasswordById(Long id, String password);

    U findByEmail(String email);

}
