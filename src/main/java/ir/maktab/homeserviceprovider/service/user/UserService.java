package ir.maktab.homeserviceprovider.service.user;

import ir.maktab.homeserviceprovider.dto.user.UserDto;
import ir.maktab.homeserviceprovider.model.user.UserModel;
import ir.maktab.homeserviceprovider.model.user.UserModelStatus;
import ir.maktab.homeserviceprovider.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.repository.user.UserRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class UserService<U extends UserModel, D extends UserDto> extends BaseService<U, D, Long> {

    private final UserRepository<U> repository;

    protected UserService(UserRepository<U> userRepository) {
        super(userRepository);
        this.repository = userRepository;
    }

    @Override
    public U save(D dto) {
        U model = this.mapper.map(dto, getModelClass());
        model.setStatus(UserModelStatus.NEW);
        model.setWallet(new WalletModel());
        return repository.save(model);
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
