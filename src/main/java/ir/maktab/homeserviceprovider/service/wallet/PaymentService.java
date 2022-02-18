package ir.maktab.homeserviceprovider.service.wallet;

import ir.maktab.homeserviceprovider.dto.wallet.PaymentDto;
import ir.maktab.homeserviceprovider.model.wallet.PaymentModel;
import ir.maktab.homeserviceprovider.repository.wallet.PaymentRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends BaseService<PaymentModel, PaymentDto, Long> {

    private PaymentRepository repository;

    public PaymentService(PaymentRepository paymentRepository) {
        super(paymentRepository);
        this.repository = paymentRepository;
    }

    @Override
    protected Class<PaymentModel> getModelClass() {
        return PaymentModel.class;
    }

}
