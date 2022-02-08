package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Expert extends User {

    @OneToMany(mappedBy = "expert")
    private Set<Offer> offers = new HashSet<>();

    @OneToMany(mappedBy = "expert")
    private Set<Review> reviews = new HashSet<>();

    @Builder(builderMethodName = "expertBuilder")
    public Expert(String firstname, String lastname, String email, String password, UserStatus status) {
        super(firstname, lastname, email, password, status);
    }
}