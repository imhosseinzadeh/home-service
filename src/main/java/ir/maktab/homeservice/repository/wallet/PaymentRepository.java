package ir.maktab.homeservice.repository.wallet;

import ir.maktab.homeservice.domain.model.wallet.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
