package ir.maktab.homeserviceprovider.domain.model.user;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "\"User\"")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public class UserModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    @Email(message = "UserModel-email not valid")
    @NotBlank(message = "UserModel-email cannot be blank")
    private String email;

    @NotBlank(message = "UserModel-password cannot be blank")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for UserModel-password")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "UserModel-status cannot be null")
    private UserModelStatus status;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @NotNull(message = "UserModel-wallet cannot be null")
    @Setter(AccessLevel.NONE)
    private WalletModel wallet;

    @Builder
    public UserModel(Long id, String firstname, String lastname, String email, String password, UserModelStatus status) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.status = status;
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

    @Override
    public void onPersist() {
        super.onPersist();
        this.wallet = new WalletModel();
        wallet.setUser(this);
        this.status = UserModelStatus.NEW;
    }
}
