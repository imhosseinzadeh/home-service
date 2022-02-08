package ir.maktab.homeserviceprovider.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Review implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Expert expert;

    private String comment;

    @Type(type = "ir.maktab.homeserviceprovider.entity.Score")
    private Score score;

    @Override
    public Long getId() {
        return this.id;
    }
}