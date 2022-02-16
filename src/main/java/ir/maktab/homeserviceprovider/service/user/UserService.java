package ir.maktab.homeserviceprovider.service.user;

import ir.maktab.homeserviceprovider.model.user.UserModel;
import ir.maktab.homeserviceprovider.repository.user.UserRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService<U extends UserModel> extends BaseService<U, Long> {

    private final UserRepository<U> repository;

    public UserService(UserRepository<U> userRepository) {
        super(userRepository);
        this.repository = userRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePasswordById(Long id, String password) {
        repository.updatePasswordById(id, password);
    }

    @Transactional(readOnly = true)
    public U findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public Page<UserModel> findAllByFirstnameAndLastname(String firstname, String lastname, Pageable pageable) {
        return repository.findAllByFirstnameAndLastname(firstname, lastname, pageable);
    }
}
