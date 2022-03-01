package ir.maktab.homeserviceprovider.domain.service.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.TransactionModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.wallet.TransactionDto;
import ir.maktab.homeserviceprovider.mapper.wallet.TransactionMapper;
import ir.maktab.homeserviceprovider.repository.wallet.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<TransactionModel, TransactionDto, Long> {

    private final TransactionRepository repository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository repository, TransactionMapper transactionMapper) {
        super(repository, transactionMapper);
        this.repository = repository;
        this.transactionMapper = transactionMapper;
    }
}
