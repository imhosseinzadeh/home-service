package ir.maktab.homeserviceprovider.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Expert")
@Getter
@NoArgsConstructor
public class ExpertModel extends UserModel {

    @Lob
    @Column(columnDefinition = "mediumblob")
    @Setter
    private byte[] image;

    @OneToMany(mappedBy = "expert", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ExpertServiceModel> expertServices = new HashSet<>();

    @OneToMany(mappedBy = "expert", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OfferModel> offers = new HashSet<>();

    @OneToMany(mappedBy = "expert", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ReviewModel> reviews = new HashSet<>();

    @PositiveOrZero(message = "Expert-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    @Builder(builderMethodName = "expertBuilder")
    public ExpertModel(String firstname, String lastname, String email, String password, UserModelStatus status, WalletModel wallet, byte[] image) {
        super(firstname, lastname, email, password, status, wallet);
        this.image = image;
    }

    public Integer getScore() {
        this.score = reviews.stream().mapToInt(ReviewModel::getScore).sum() / reviews.size();
        return score;
    }

    public void setExpertServices(Set<ExpertServiceModel> expertServices) {
        expertServices.forEach(this::addExpertService);
        this.expertServices = expertServices;
    }

    public void setOffers(Set<OfferModel> offers) {
        offers.forEach(this::addOffer);
        this.offers = offers;
    }

    public void setReviews(Set<ReviewModel> reviews) {
        reviews.forEach(this::addReview);
        this.reviews = reviews;
    }

    public void addExpertService(ExpertServiceModel expertService) {
        expertService.setExpert(this);
    }

    public void removeExpertService(ExpertServiceModel expertService) {
        this.expertServices.remove(expertService);
    }

    public void addOffer(OfferModel offer) {
        offer.setExpert(this);
    }

    public void removeOffer(OfferModel offer) {
        this.offers.remove(offer);
    }

    public void addReview(ReviewModel review) {
        review.setExpert(this);
    }

    public void removeReview(ReviewModel review) {
        this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return "Expert{" +
                "id=" + getId() +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", status=" + getStatus() +
                ", signDate=" + getSignDate() +
                ", score=" + score +
                '}';
    }
}