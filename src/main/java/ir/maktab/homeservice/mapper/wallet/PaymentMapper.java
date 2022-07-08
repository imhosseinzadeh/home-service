package ir.maktab.homeservice.mapper.wallet;

import ir.maktab.homeservice.domain.model.wallet.PaymentModel;
import ir.maktab.homeservice.dto.wallet.PaymentDto;
import ir.maktab.homeservice.mapper.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper extends AbstractMapper<PaymentModel, PaymentDto, Long> {

}
