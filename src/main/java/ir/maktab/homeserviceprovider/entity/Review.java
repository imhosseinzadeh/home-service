package ir.maktab.homeserviceprovider.entity;

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

    private Integer score;

    @Override
    public Long getId() {
        return this.id;
    }

    public Integer getScore() {
        return score;
    }
}