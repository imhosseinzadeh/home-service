package ir.maktab.homeserviceprovider.domain.service.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.wallet.WalletDto;
import ir.maktab.homeserviceprovider.mapper.wallet.WalletMapper;
import ir.maktab.homeserviceprovider.repository.wallet.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService extends BaseService<WalletModel, WalletDto, Long> {

    private final WalletRepository repository;
    private final WalletMapper walletMapper;

    public WalletService(WalletRepository repository, WalletMapper walletMapper) {
        super(repository, walletMapper);
        this.repository = repository;
        this.walletMapper = walletMapper;
    }
}
