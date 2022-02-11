package ir.maktab.homeserviceprovider.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Customer")
@Getter
@NoArgsConstructor
public class CustomerModel extends UserModel {

    @OneToMany(mappedBy = "customer")
    private Set<OrderModel> orders = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<ReviewModel> reviews = new HashSet<>();

    @Builder(builderMethodName = "customerBuilder")
    public CustomerModel(String firstname, String lastname, String email, String password, UserModelStatus status, WalletModel wallet) {
        super(firstname, lastname, email, password, status, wallet);
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
                ", signDate=" + getSignDate() +
                '}';
    }
}