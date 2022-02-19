package ir.maktab.homeserviceprovider.repository.user;

import ir.maktab.homeserviceprovider.domain.model.user.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<U extends UserModel> extends JpaRepository<U, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE #{#entityName} u SET u.password= :password WHERE u.id= :id")
    void updatePasswordById(Long id, String password);

    U findByEmail(String email);

    Page<UserModel> findAllByFirstnameAndLastname(String firstname, String lastname, Pageable pageable);
}
