package ir.maktab.homeserviceprovider.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

@Entity
public class Offer implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Expert expert;

    @ManyToOne
    private Order order;

    private BigDecimal price;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime submitDate;

    @Column(precision = 19, scale = 4, columnDefinition = "DECIMAL(19,4)")
    private BigDecimal proposalPrice;

    private Period period;

    private LocalTime startTime;

    @Override
    public Long getId() {
        return this.id;
    }

    @PrePersist
    protected void onCreate() {
        submitDate = LocalDateTime.now();
    }
}