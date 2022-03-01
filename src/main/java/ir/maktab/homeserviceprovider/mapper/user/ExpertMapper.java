package ir.maktab.homeserviceprovider.mapper.user;

import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import ir.maktab.homeserviceprovider.dto.user.ExpertDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ExpertMapper extends AbstractUserMapper<ExpertModel, ExpertDto> {

}
