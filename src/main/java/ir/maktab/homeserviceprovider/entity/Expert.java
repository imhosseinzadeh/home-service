package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Expert extends User {

    @OneToMany(mappedBy = "expert")
    private Set<Offer> offers = new HashSet<>();

    @OneToMany(mappedBy = "expert")
    private Set<Review> reviews = new HashSet<>();

    @Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] image;

    @Builder(builderMethodName = "expertBuilder")
    public Expert(String firstname, String lastname, String email, String password, UserStatus status, byte[] image) {
        super(firstname, lastname, email, password, status);
        this.image = image;
    }
}