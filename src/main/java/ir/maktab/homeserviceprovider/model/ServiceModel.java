package ir.maktab.homeserviceprovider.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Service")
public class ServiceModel implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Service-name cannot be null")
    private String name;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SubServiceModel> subServices = new HashSet<>();

    @OneToMany(mappedBy = "service")
    private Set<ExpertServiceModel> expertServices = new HashSet<>();

    @Override
    public Long getId() {
        return this.id;
    }
}