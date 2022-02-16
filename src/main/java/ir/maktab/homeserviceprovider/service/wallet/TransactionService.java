package ir.maktab.homeserviceprovider.service.wallet;

import ir.maktab.homeserviceprovider.model.wallet.TransactionModel;
import ir.maktab.homeserviceprovider.repository.wallet.TransactionRepository;
import ir.maktab.homeserviceprovider.service.BaseService;

public class TransactionService extends BaseService<TransactionModel, Long> {

    private TransactionRepository repository;

    public TransactionService(TransactionRepository transactionRepository) {
        super(transactionRepository);
        this.repository = transactionRepository;
    }
}
