package ir.maktab.homeserviceprovider.mapper.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.dto.wallet.WalletDto;
import ir.maktab.homeserviceprovider.mapper.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class WalletMapper extends AbstractMapper<WalletModel, WalletDto, Long> {

}
