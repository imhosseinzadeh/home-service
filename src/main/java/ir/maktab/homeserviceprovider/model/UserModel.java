package ir.maktab.homeserviceprovider.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity(name = "User")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class UserModel implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    @Email(message = "user-email not valid")
    @NotNull(message = "User-email cannot be null")
    private String email;

    @NotNull(message = "User-password cannot be null")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for user-password")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "User-status cannot be null")
    private UserModelStatus status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @NotNull(message = "User-wallet cannot be null")
    private WalletModel wallet;

    @CreationTimestamp
    @Column(updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime signDate;

    @Builder
    public UserModel(String firstname, String lastname, String email, String password, UserModelStatus status, WalletModel wallet) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.status = status;
        setWallet(wallet);
    }

    public void setWallet(@NotNull(message = "User-wallet cannot be null") WalletModel wallet) {
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
                ", signDate=" + signDate +
                '}';
    }
}
