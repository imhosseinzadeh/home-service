package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.model.UserModel;
import ir.maktab.homeserviceprovider.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService<U extends UserModel> extends BaseService<U, Long> {

    private final UserRepository<U> repository;

    public UserService(UserRepository<U> userRepository) {
        super(userRepository);
        this.repository = userRepository;
    }

    public void updatePasswordById(Long id, String password) {
        repository.updatePasswordById(id, password);
    }

    U findByEmail(String email) {
        return repository.findByEmail(email);
    }

    Page<UserModel> findAllByFirstnameAndLastname(String firstname, String lastname, Pageable pageable) {
        return repository.findAllByFirstnameAndLastname(firstname, lastname, pageable);
    }
}
