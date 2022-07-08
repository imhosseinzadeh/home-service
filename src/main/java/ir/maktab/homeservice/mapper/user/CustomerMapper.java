package ir.maktab.homeservice.mapper.user;

import ir.maktab.homeservice.domain.model.user.CustomerModel;
import ir.maktab.homeservice.dto.user.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper extends AbstractUserMapper<CustomerModel, CustomerDto> {

}
