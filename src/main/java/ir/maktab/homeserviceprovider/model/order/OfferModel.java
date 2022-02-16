package ir.maktab.homeserviceprovider.model.order;

import ir.maktab.homeserviceprovider.model.BaseModel;
import ir.maktab.homeserviceprovider.model.order.OrderModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private ExpertModel expert;

    @ManyToOne
    private OrderModel order;

    @Column(precision = 19, scale = 4, columnDefinition = "DECIMAL(19,4)")
    private BigDecimal proposalPrice;

    private LocalTime startTime;

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
