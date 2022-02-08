package ir.maktab.homeserviceprovider.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Order\"")
public class Order implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private SubService subService;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private Set<Offer> offers = new HashSet<>();

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

    @PrePersist
    protected void onCreate() {
        submitDate = LocalDateTime.now();
    }
}
