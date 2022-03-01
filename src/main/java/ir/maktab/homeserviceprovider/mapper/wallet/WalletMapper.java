package ir.maktab.homeserviceprovider.mapper.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.dto.wallet.WalletDto;
import ir.maktab.homeserviceprovider.mapper.AbstractMapper;
import ir.maktab.homeserviceprovider.mapper.user.CustomerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public abstract class WalletMapper extends AbstractMapper<WalletModel, WalletDto, Long> {

    @Mapping(target = "userId", source = "user.id")
    public abstract WalletDto mapToDto(WalletModel model);

    @Mapping(target = "user", source = "userId")
    public abstract WalletModel mapToModel(WalletDto dto);

    @Mapping(target = "userId", source = "user.id")
    public abstract void updateDtoByModel(@MappingTarget WalletDto dto, WalletModel model);

    @Mapping(target = "user", source = "userId")
    public abstract void updateModelByDto(@MappingTarget WalletModel model, WalletDto dto);

}
