package ir.maktab.homeservice.repository.wallet;

import ir.maktab.homeservice.domain.model.wallet.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
}
