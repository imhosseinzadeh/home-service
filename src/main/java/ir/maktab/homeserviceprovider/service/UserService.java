package ir.maktab.homeserviceprovider.service;

import ir.maktab.homeserviceprovider.entity.User;
import ir.maktab.homeserviceprovider.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Long> {

    private UserRepository repository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.repository = userRepository;
    }

    public void updatePasswordById(Long id, String password) {
        repository.updatePasswordById(id, password);
    }
}
