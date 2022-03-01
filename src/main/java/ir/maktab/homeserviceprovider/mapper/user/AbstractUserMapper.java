package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.UserModel;
import ir.maktab.homeserviceprovider.dto.user.UserDto;
import ir.maktab.homeserviceprovider.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractUserMapper<U extends UserModel, D extends UserDto> extends AbstractMapper<U, D, Long> {

}
