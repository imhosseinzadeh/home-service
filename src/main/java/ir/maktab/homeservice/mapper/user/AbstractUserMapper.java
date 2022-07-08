package ir.maktab.homeservice.mapper.user;

import ir.maktab.homeservice.domain.model.user.UserModel;
import ir.maktab.homeservice.dto.user.UserDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractUserMapper<U extends UserModel, D extends UserDto> extends AbstractMapper<U, D, Long> {

}
