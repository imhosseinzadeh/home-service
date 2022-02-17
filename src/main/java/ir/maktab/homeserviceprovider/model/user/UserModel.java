package ir.maktab.homeserviceprovider.model.user;

import ir.maktab.homeserviceprovider.model.BaseModel;
import ir.maktab.homeserviceprovider.model.wallet.WalletModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class UserModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    @Email(message = "User-email not valid")
    @NotBlank(message = "User-email cannot be null")
    private String email;

    @NotBlank(message = "User-password cannot be null")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for user-password")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "User-status cannot be blank")
    private UserModelStatus status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @NotBlank(message = "User-wallet cannot be blank")
    private WalletModel wallet;

    @Builder
    public UserModel(String firstname, String lastname, String email, String password, UserModelStatus status, WalletModel wallet) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.status = status;
        setWallet(wallet);
    }

    public void setWallet(@NotBlank(message = "User-wallet cannot be blank") WalletModel wallet) {
        wallet.setUser(this);
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", wallet balance=" + wallet.getBalance() +
                '}';
    }
}
