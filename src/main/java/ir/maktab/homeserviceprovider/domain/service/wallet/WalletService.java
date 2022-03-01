package ir.maktab.homeserviceprovider.domain.service.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.wallet.WalletDto;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import ir.maktab.homeserviceprovider.mapper.wallet.WalletMapper;
import ir.maktab.homeserviceprovider.repository.wallet.WalletRepository;
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
