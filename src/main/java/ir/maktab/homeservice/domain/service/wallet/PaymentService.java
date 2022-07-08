package ir.maktab.homeservice.domain.service.wallet;

import ir.maktab.homeservice.domain.model.wallet.PaymentModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.wallet.PaymentDto;
import ir.maktab.homeservice.mapper.wallet.PaymentMapper;
import ir.maktab.homeservice.repository.wallet.PaymentRepository;
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
