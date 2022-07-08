package ir.maktab.homeservice.domain.model.user;

import ir.maktab.homeservice.domain.model.order.OrderModel;
import ir.maktab.homeservice.domain.model.order.ReviewModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"Customer\"")
@NoArgsConstructor
@Getter
@Setter
public class CustomerModel extends UserModel {

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<OrderModel> orders = new HashSet<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ReviewModel> reviews = new HashSet<>();

    @Builder(builderMethodName = "customerBuilder")
    public CustomerModel(Long id, String firstname, String lastname, String email, String password, UserModelStatus status) {
        super(id, firstname, lastname, email, password, status);
    }

    public void setOrders(Set<OrderModel> orders) {
        orders.forEach(this::addOrder);
        this.orders = orders;
    }

    public void setReviews(Set<ReviewModel> reviews) {
        reviews.forEach(this::addReview);
        this.reviews = reviews;
    }

    public void addOrder(OrderModel order) {
        order.setCustomer(this);
    }

    public void removeOrder(OrderModel order) {
        this.orders.remove(order);
    }

    public void addReview(ReviewModel review) {
        review.setCustomer(this);
    }

    public void removeReview(ReviewModel review) {
        this.reviews.remove(review);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", status=" + getStatus() +
                ", createDate=" + getCreateDate() +
                '}';
    }
}