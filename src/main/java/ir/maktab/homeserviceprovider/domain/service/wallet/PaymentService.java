package ir.maktab.homeserviceprovider.domain.service.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.PaymentModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.wallet.PaymentDto;
import ir.maktab.homeserviceprovider.mapper.wallet.PaymentMapper;
import ir.maktab.homeserviceprovider.repository.wallet.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends BaseService<PaymentModel, PaymentDto, Long> {

    private final PaymentRepository repository;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository repository, PaymentMapper paymentMapper) {
        super(repository, paymentMapper);
        this.repository = repository;
        this.paymentMapper = paymentMapper;
    }
}
