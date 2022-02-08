package ir.maktab.homeserviceprovider.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class User implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime signDate;

    @UpdateTimestamp
    private LocalDateTime modifyDate;

    @Type(type = "ir.maktab.homeserviceprovider.entity.UserStatus")
    private UserStatus status;

    @Builder
    public User(String firstname, String lastname, String email, String password, UserStatus status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        signDate = modifyDate = LocalDateTime.now();
    }

}