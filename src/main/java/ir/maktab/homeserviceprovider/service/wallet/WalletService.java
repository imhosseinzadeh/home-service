package ir.maktab.homeserviceprovider.service.wallet;

import ir.maktab.homeserviceprovider.dto.wallet.WalletDto;
import ir.maktab.homeserviceprovider.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.repository.wallet.WalletRepository;
import ir.maktab.homeserviceprovider.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class WalletService extends BaseService<WalletModel, WalletDto, Long> {

    private WalletRepository repository;

    public WalletService(WalletRepository walletRepository) {
        super(walletRepository);
        this.repository = walletRepository;
    }

    @Override
    protected Class<WalletModel> getModelClass() {
        return WalletModel.class;
    }

    @Override
    protected Class<WalletDto> getDtoClass() {
        return WalletDto.class;
    }

}
