package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.User;
import ir.maktab.homeserviceprovider.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService<U extends User> extends BaseService<U, Long> {

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
}
