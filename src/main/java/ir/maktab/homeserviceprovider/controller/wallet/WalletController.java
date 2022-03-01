package ir.maktab.homeserviceprovider.controller.wallet;

import ir.maktab.homeserviceprovider.domain.service.wallet.WalletService;
import ir.maktab.homeserviceprovider.exception.DataNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("balance/{walletId}")
    public ResponseEntity<BigDecimal> seeBalance(@PathVariable Long walletId) {
        try {
            return ResponseEntity.ok(this.walletService.seeBalance(walletId));
        } catch (DataNotExistsException e) {
            e.printStackTrace();
        }
        return null;
    }

}
