package ir.maktab.homeservice.domain.model.order;

import ir.maktab.homeservice.domain.model.BaseModel;
import ir.maktab.homeservice.domain.model.service.SubServiceModel;
import ir.maktab.homeservice.domain.model.user.CustomerModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class OrderModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "OrderModel-customer cannot be null")
    private CustomerModel customer;

    @ManyToOne
    @NotNull(message = "OrderModel-subService cannot be null")
    private SubServiceModel subService;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "OrderModel-status cannot be null")
    private OrderModelStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OfferModel> offers = new HashSet<>();

    @OneToOne
    private OfferModel acceptedOffer;

    @NotNull(message = "OrderModel-proposedPrice cannot be null")
    private BigDecimal proposedPrice;

    @NotBlank(message = "OrderModel-description cannot be blank")
    private String description;

    @NotBlank(message = "OrderModel-address cannot be blank")
    private String address;

    @NotNull(message = "OrderModel-dateTime cannot be blank")
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

    public void setAcceptedOffer(OfferModel acceptedOffer) {
        this.acceptedOffer = acceptedOffer;
        this.status = OrderModelStatus.WAIT_FOR_EXPERT_TO_COME_TO_YOUR_PLACE;
    }

    public void addOffer(OfferModel offer) {
        offer.setOrder(this);
    }

    public void removeOffer(OfferModel offer) {
        this.offers.remove(offer);
    }

    @Override
    public void onPersist() {
        super.onPersist();
        this.status = OrderModelStatus.WAIT_FOR_EXPERTS_SUGGESTIONS;
    }

}
