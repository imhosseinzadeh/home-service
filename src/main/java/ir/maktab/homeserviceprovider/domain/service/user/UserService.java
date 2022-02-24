package ir.maktab.homeserviceprovider.domain.service.user;

import ir.maktab.homeserviceprovider.domain.model.user.UserModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.user.UserDto;
import ir.maktab.homeserviceprovider.dto.user.param.ChangePasswordParam;
import ir.maktab.homeserviceprovider.dto.user.param.UserSearchParam;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.exception.WrongDataInputException;
import ir.maktab.homeserviceprovider.repository.user.UserRepository;
import ir.maktab.homeserviceprovider.repository.user.UserSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public abstract class UserService<U extends UserModel, D extends UserDto> extends BaseService<U, D, Long> {

    private final UserRepository<U> repository;
    private final UserSpecifications<U> specifications;

    protected UserService(UserRepository<U> userRepository, UserSpecifications<U> specifications) {
        super(userRepository);
        this.repository = userRepository;
        this.specifications = specifications;
    }

    @Transactional(readOnly = true)
    public abstract Page<U> findAll(UserSearchParam searchParam, Pageable pageable);

    @Transactional(readOnly = true)
    public U findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Transactional
    public void updatePasswordById(Long id, ChangePasswordParam param) throws DataNotExistsException, WrongDataInputException {
        Optional<D> optUser = load(id);
        if (optUser.isPresent()) {

            String userPass = optUser.get().getPassword();
            String paramOldPass = param.getOldPassword();

            if (userPass.equals(paramOldPass)) {
                this.repository.updatePasswordById(id, param.getNewPassword());
                return;
            }
            throw new WrongDataInputException("Wrong current password");
        }
        throw new DataNotExistsException("User with id: " + id + "does not exist");
    }

}
