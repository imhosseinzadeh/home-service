package ir.maktab.homeserviceprovider.domain.service.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.PaymentModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.wallet.PaymentDto;
import ir.maktab.homeserviceprovider.repository.wallet.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends BaseService<PaymentModel, PaymentDto, Long> {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository paymentRepository) {
        super(paymentRepository);
        this.repository = paymentRepository;
    }

    @Override
    protected Class<PaymentModel> getModelClass() {
        return PaymentModel.class;
    }

    @Override
    protected Class<PaymentDto> getDtoClass() {
        return PaymentDto.class;
    }

}
