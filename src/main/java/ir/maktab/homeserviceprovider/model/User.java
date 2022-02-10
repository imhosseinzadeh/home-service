package ir.maktab.homeserviceprovider.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class User implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    @Email
    @NotNull(message = "User-email cannot be null")
    private String email;

    @NotNull(message = "User-password cannot be null")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Incorrect pattern for user-password")
    private String password;

    @Type(type = "ir.maktab.homeserviceprovider.model.UserStatus")
    @NotNull(message = "User-status cannot be null")
    private UserStatus status;

    @CreationTimestamp
    @Column(updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime signDate;

    @Builder
    public User(String firstname, String lastname, String email, String password, UserStatus status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.status = status;
    }
}