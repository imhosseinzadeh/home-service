package ir.maktab.homeserviceprovider.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SubService implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Service service;

    @OneToMany(mappedBy = "subService")
    private Set<Order> orders = new HashSet<>();

    private BigDecimal basePrice;

    private String explanation;

    @Override
    public Long getId() {
        return this.id;
    }
}