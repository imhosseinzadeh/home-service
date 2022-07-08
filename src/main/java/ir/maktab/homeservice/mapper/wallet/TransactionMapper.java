package ir.maktab.homeservice.mapper.wallet;

import ir.maktab.homeservice.domain.model.wallet.TransactionModel;
import ir.maktab.homeservice.dto.wallet.TransactionDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TransactionMapper extends AbstractMapper<TransactionModel, TransactionDto, Long> {

}
