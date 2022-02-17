package ir.maktab.homeserviceprovider.model.order;

import ir.maktab.homeserviceprovider.model.BaseModel;
import ir.maktab.homeserviceprovider.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity(name = "Review")
@Getter
public class ReviewModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CustomerModel customer;

    @ManyToOne
    private ExpertModel expert;

    @NotBlank(message = "Review-score can not be blank")
    @PositiveOrZero(message = "Review-score must be positive or zero")
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