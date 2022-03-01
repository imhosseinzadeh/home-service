package ir.maktab.homeserviceprovider.mapper.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.PaymentModel;
import ir.maktab.homeserviceprovider.dto.wallet.PaymentDto;
import ir.maktab.homeserviceprovider.mapper.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PaymentMapper extends AbstractMapper<PaymentModel, PaymentDto, Long> {

}
