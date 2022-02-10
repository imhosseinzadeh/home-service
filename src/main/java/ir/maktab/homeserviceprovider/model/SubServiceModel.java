package ir.maktab.homeserviceprovider.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SubServiceModel implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "SubService-name cannot null")
    private String name;

    @ManyToOne
    @NotNull(message = "SubService cannot exists without service")
    private ServiceModel service;

    @OneToMany(mappedBy = "subService")
    private Set<OrderModel> orders = new HashSet<>();

    private BigDecimal basePrice;

    private String comment;

    @Override
    public Long getId() {
        return this.id;
    }
}