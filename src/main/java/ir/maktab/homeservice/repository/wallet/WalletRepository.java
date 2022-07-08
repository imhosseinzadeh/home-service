package ir.maktab.homeservice.repository.wallet;

import ir.maktab.homeservice.domain.model.wallet.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel, Long> {
}
