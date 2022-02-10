package ir.maktab.homeserviceprovider.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class ExpertModel extends UserModel {

    @Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] image;

    @OneToMany(mappedBy = "expert")
    private Set<ExpertServiceModel> expertServices = new HashSet<>();

    @OneToMany(mappedBy = "expert")
    private Set<OfferModel> offers = new HashSet<>();

    @OneToMany(mappedBy = "expert")
    private Set<ReviewModel> reviews = new HashSet<>();

    @PositiveOrZero(message = "Expert-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    public Integer getScore() {
        this.score = reviews.stream().mapToInt(ReviewModel::getScore).sum() / reviews.size();
        return score;
    }

    @Builder(builderMethodName = "expertBuilder")
    public ExpertModel(String firstname, String lastname, String email, String password, UserModelStatus status, byte[] image) {
        super(firstname, lastname, email, password, status);
        this.image = image;
    }
}