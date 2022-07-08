package ir.maktab.homeservice.domain.service.wallet;

import ir.maktab.homeservice.domain.model.wallet.WalletModel;
import ir.maktab.homeservice.domain.service.BaseService;
import ir.maktab.homeservice.dto.wallet.WalletDto;
import ir.maktab.homeservice.exception.DataNotExistsException;
import ir.maktab.homeservice.mapper.wallet.WalletMapper;
import ir.maktab.homeservice.repository.wallet.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WalletService extends BaseService<WalletModel, WalletDto, Long> {

    private final WalletRepository repository;
    private final WalletMapper walletMapper;

    public WalletService(WalletRepository repository, WalletMapper walletMapper) {
        super(repository, walletMapper);
        this.repository = repository;
        this.walletMapper = walletMapper;
    }

    @Transactional(readOnly = true)
    public BigDecimal seeBalance(Long walletId) throws DataNotExistsException {
        Optional<WalletModel> optWallet = repository.findById(walletId);
        if (optWallet.isPresent()) {
            return optWallet.get().getBalance();
        }
        throw new DataNotExistsException("");
    }

}
