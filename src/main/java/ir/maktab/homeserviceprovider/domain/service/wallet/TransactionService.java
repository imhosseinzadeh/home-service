package ir.maktab.homeserviceprovider.domain.service.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.TransactionModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.wallet.TransactionDto;
import ir.maktab.homeserviceprovider.repository.wallet.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<TransactionModel, TransactionDto, Long> {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository transactionRepository) {
        super(transactionRepository);
        this.repository = transactionRepository;
    }

    @Override
    protected Class<TransactionModel> getModelClass() {
        return TransactionModel.class;
    }

    @Override
    protected Class<TransactionDto> getDtoClass() {
        return TransactionDto.class;
    }

}
