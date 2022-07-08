package ir.maktab.homeservice.domain.service.wallet;

import ir.maktab.homeservice.domain.model.wallet.TransactionModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.wallet.TransactionDto;
import ir.maktab.homeservice.mapper.wallet.TransactionMapper;
import ir.maktab.homeservice.repository.wallet.TransactionRepository;
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
