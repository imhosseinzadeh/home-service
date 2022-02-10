package ir.maktab.homeserviceprovider.model;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Service")
@Getter
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSubServices(Set<SubServiceModel> subServices) {
        subServices.forEach(this::addSubService);
        this.subServices = subServices;
    }

    public void setExpertServices(Set<ExpertServiceModel> expertServices) {
        expertServices.forEach(this::addExpertService);
        this.expertServices = expertServices;
    }

    public void addSubService(SubServiceModel subService) {
        subService.setService(this);
    }

    public void removeSubService(SubServiceModel subService) {
        this.subServices.remove(subService);
    }

    public void addExpertService(ExpertServiceModel expertService) {
        expertService.setService(this);
    }

    public void removeExpertService(ExpertServiceModel expertService) {
        this.expertServices.remove(expertService);
    }
}