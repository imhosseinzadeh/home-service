package ir.maktab.homeserviceprovider.model.service;

import ir.maktab.homeserviceprovider.model.BaseModel;
import ir.maktab.homeserviceprovider.model.order.OrderModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "SubService")
@Getter
@Setter
public class SubServiceModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "SubService-name cannot blank")
    private String name;

    @ManyToOne
    @NotBlank(message = "SubService cannot exists without service")
    private ServiceModel service;

    @OneToMany(mappedBy = "subService", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OrderModel> orders = new HashSet<>();

    private BigDecimal basePrice;

    private String comment;

    public void setService(ServiceModel service) {
        service.getSubServices().add(this);
        this.service = service;
    }

    public void setOrders(Set<OrderModel> orders) {
        orders.forEach(this::addOrder);
        this.orders = orders;
    }

    public void addOrder(OrderModel order) {
        order.setSubService(this);
    }

    public void removeOrder(OrderModel order) {
        this.orders.remove(order);
    }

    @Override
    public String toString() {
        return "SubServiceModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", service=" + service +
                ", basePrice=" + basePrice +
                ", comment='" + comment + '\'' +
                '}';
    }
}