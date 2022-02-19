package ir.maktab.homeserviceprovider.repository.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel, Long> {
}
