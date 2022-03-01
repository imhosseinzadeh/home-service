package ir.maktab.homeserviceprovider.mapper.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.TransactionModel;
import ir.maktab.homeserviceprovider.dto.wallet.TransactionDto;
import ir.maktab.homeserviceprovider.mapper.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper extends AbstractMapper<TransactionModel, TransactionDto, Long> {

}
