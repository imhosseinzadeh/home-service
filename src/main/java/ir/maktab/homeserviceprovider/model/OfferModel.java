package ir.maktab.homeserviceprovider.model;

import lombok.Getter;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

@Entity(name = "Offer")
@Getter
public class OfferModel implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ExpertModel expert;

    @ManyToOne
    private OrderModel order;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime submitDate;

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