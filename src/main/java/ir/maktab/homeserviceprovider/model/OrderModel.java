package ir.maktab.homeserviceprovider.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "\"Order\"")
@Getter
@Setter
@RequiredArgsConstructor
public class OrderModel implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    private CustomerModel customer;

    @ManyToOne
    private SubServiceModel subService;

    @Type(type = "ir.maktab.homeserviceprovider.model.OrderModelStatus")
    @NotNull(message = "Order-status cannot be null")
    private OrderModelStatus status;

    @OneToMany(mappedBy = "order")
    private Set<OfferModel> offers = new HashSet<>();

    @CreationTimestamp
    @Column(updatable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime submitDate;

    @Column(precision = 19, scale = 4, columnDefinition = "DECIMAL(19,4)")
    private BigDecimal proposedPrice;

    private String description;

    private String address;

    private LocalDateTime dateTime;

    public void setCustomer(CustomerModel customer) {
        customer.getOrders().add(this);
        this.customer = customer;
    }

    public void setSubService(SubServiceModel subService) {
        subService.getOrders().add(this);
        this.subService = subService;
    }

    public void setOffers(Set<OfferModel> offers) {
        offers.forEach(this::addOffer);
        this.offers = offers;
    }

    public void addOffer(OfferModel offer) {
        offer.setOrder(this);
    }

    public void removeOffer(OfferModel offer) {
        this.offers.remove(offer);
    }
}