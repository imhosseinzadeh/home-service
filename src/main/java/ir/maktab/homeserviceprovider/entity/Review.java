package ir.maktab.homeserviceprovider.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Review implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Expert expert;

    @NotNull
    @PositiveOrZero(message = "Review-score must be positive or zero")
    @Range(min = 0, max = 5)
    private Integer score;

    private String comment;

    @Override
    public Long getId() {
        return this.id;
    }

    public Integer getScore() {
        return score;
    }
}