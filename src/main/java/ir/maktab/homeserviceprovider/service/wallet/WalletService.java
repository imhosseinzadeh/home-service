package ir.maktab.homeserviceprovider.service.wallet;

import ir.maktab.homeserviceprovider.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.repository.wallet.WalletRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class WalletService extends BaseService<WalletModel, Long> {

    private WalletRepository repository;

    public WalletService(WalletRepository walletRepository) {
        super(walletRepository);
        this.repository = walletRepository;
    }
}
