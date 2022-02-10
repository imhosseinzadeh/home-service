package ir.maktab.homeserviceprovider.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Expert extends User implements Serializable {

    @Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] image;

    @OneToMany(mappedBy = "expert")
    private Set<ExpertService> expertServices = new HashSet<>();

    @OneToMany(mappedBy = "expert")
    private Set<Offer> offers = new HashSet<>();

    @OneToMany(mappedBy = "expert")
    private Set<Review> reviews = new HashSet<>();

    @PositiveOrZero(message = "Expert-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    public Integer getScore() {
        this.score = reviews.stream().mapToInt(Review::getScore).sum() / reviews.size();
        return score;
    }

    @Builder(builderMethodName = "expertBuilder")
    public Expert(String firstname, String lastname, String email, String password, UserStatus status, byte[] image) {
        super(firstname, lastname, email, password, status);
        this.image = image;
    }
}