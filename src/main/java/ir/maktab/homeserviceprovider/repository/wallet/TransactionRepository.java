package ir.maktab.homeserviceprovider.repository.wallet;

import ir.maktab.homeserviceprovider.model.wallet.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
}
