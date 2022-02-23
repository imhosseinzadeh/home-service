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
    protected PaymentDto mapToDto(PaymentModel model) {
        return null;
    }

    @Override
    protected PaymentModel mapToModel(PaymentDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(PaymentDto dto, PaymentModel model) {

    }
}
