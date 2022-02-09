package ir.maktab.homeserviceprovider.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SubService implements BaseEntity<Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "SubService-name cannot null")
    private String name;

    @ManyToOne
    @NotNull(message = "SubService cannot exists without service")
    private Service service;

    @OneToMany(mappedBy = "subService")
    private Set<Order> orders = new HashSet<>();

    private BigDecimal basePrice;

    private String comment;

    @Override
    public Long getId() {
        return this.id;
    }
}