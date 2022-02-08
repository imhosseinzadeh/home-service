package ir.maktab.homeserviceprovider.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SubService> subServices = new HashSet<>();

    @Override
    public Long getId() {
        return this.id;
    }
}