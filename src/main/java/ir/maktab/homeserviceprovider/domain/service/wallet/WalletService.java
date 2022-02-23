package ir.maktab.homeserviceprovider.domain.service.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.domain.service.BaseService;
import ir.maktab.homeserviceprovider.dto.wallet.WalletDto;
import ir.maktab.homeserviceprovider.repository.wallet.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService extends BaseService<WalletModel, WalletDto, Long> {

    private final WalletRepository repository;

    public WalletService(WalletRepository walletRepository) {
        super(walletRepository);
        this.repository = walletRepository;
    }

    @Override
    protected WalletDto mapToDto(WalletModel model) {
        return null;
    }

    @Override
    protected WalletModel mapToModel(WalletDto dto) {
        return null;
    }

    @Override
    protected void updateModelByDto(WalletDto dto, WalletModel model) {

    }
}
