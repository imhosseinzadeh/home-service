package ir.maktab.homeserviceprovider.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Order\"")
public class OrderModel implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CustomerModel customer;

    @ManyToOne
    private SubServiceModel subService;

    @Type(type = "ir.maktab.homeserviceprovider.model.OrderModelStatus")
    @NotNull
    private OrderModelStatus status;

    @OneToMany(mappedBy = "order")
    private Set<OfferModel> offers = new HashSet<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime submitDate;

    @Column(precision = 19, scale = 4, columnDefinition = "DECIMAL(19,4)")
    private BigDecimal proposedPrice;

    private String description;

    private String address;

    private LocalDateTime dateTime;

    @Override
    public Long getId() {
        return this.id;
    }
}
