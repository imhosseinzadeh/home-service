package ir.maktab.homeserviceprovider.model.order;

import ir.maktab.homeserviceprovider.model.BaseModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.Period;

@Entity(name = "Offer")
@Getter
@Setter
public class OfferModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @NotNull(message = "OfferModel-expert cannot be null")
    private ExpertModel expert;

    @ManyToOne
    @NotNull(message = "OfferModel-order cannot be null")
    private OrderModel order;

    @NotNull(message = "OfferModel-proposalPrice cannot be null")
    private BigDecimal proposalPrice;

    @NotNull(message = "OfferModel-startTime cannot be null")
    private LocalTime startTime;

    @NotNull(message = "OfferModel-period cannot be null")
    private Period period;

    public void setExpert(ExpertModel expert) {
        expert.getOffers().add(this);
        this.expert = expert;
    }

    public void setOrder(OrderModel order) {
        order.getOffers().add(this);
        this.order = order;
    }
}
