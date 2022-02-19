package ir.maktab.homeserviceprovider.repository.wallet;

import ir.maktab.homeserviceprovider.domain.model.wallet.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
