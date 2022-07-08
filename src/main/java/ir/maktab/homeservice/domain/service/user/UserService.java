package ir.maktab.homeservice.domain.service.user;

import ir.maktab.homeservice.domain.model.user.UserModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.user.UserDto;
import ir.maktab.homeservice.dto.user.param.ChangePasswordParam;
import ir.maktab.homeservice.dto.user.param.UserSearchParam;
import ir.maktab.homeservice.exception.DataNotExistsException;
import ir.maktab.homeservice.exception.WrongDataInputException;
import ir.maktab.homeservice.mapper.user.AbstractUserMapper;
import ir.maktab.homeservice.repository.user.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public abstract class UserService<U extends UserModel, D extends UserDto> extends BaseService<U, D, Long> {

    private final UserRepository<U> repository;
    private final AbstractUserMapper<U, D> userMapper;

    public UserService(UserRepository<U> repository, AbstractUserMapper<U, D> userMapper) {
        super(repository, userMapper);
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public abstract Page<D> findAll(UserSearchParam searchParam, Pageable pageable);

    @Transactional(readOnly = true)
    public D findByEmail(String email) {
        return userMapper.mapToDto(repository.findByEmail(email));
    }

    @Transactional
    public void updatePasswordById(Long id, ChangePasswordParam param) throws DataNotExistsException, WrongDataInputException {
        Optional<D> optUser = findById(id);
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
