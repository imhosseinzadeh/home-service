package ir.maktab.homeserviceprovider.service.wallet;

import ir.maktab.homeserviceprovider.dto.wallet.TransactionDto;
import ir.maktab.homeserviceprovider.model.wallet.TransactionModel;
import ir.maktab.homeserviceprovider.repository.wallet.TransactionRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<TransactionModel, TransactionDto, Long> {

    private TransactionRepository repository;

    public TransactionService(TransactionRepository transactionRepository) {
        super(transactionRepository);
        this.repository = transactionRepository;
    }

    @Override
    protected Class<TransactionModel> getModelClass() {
        return TransactionModel.class;
    }

}
