package ir.maktab.homeserviceprovider.domain.model.order;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity(name = "Review")
@Getter
@Setter
public class ReviewModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "ReviewModel-customer cannot be null")
    private CustomerModel customer;

    @ManyToOne
    @NotNull(message = "ReviewModel-expert cannot be null")
    private ExpertModel expert;

    @NotNull(message = "ReviewModel-score cannot be null")
    @PositiveOrZero(message = "ReviewModel-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    private String comment;

    public void setCustomer(CustomerModel customer) {
        customer.getReviews().add(this);
        this.customer = customer;
    }

    public void setExpert(ExpertModel expert) {
        expert.getReviews().add(this);
        this.expert = expert;
    }
}