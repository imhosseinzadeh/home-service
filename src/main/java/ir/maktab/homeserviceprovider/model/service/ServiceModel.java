package ir.maktab.homeserviceprovider.model.service;

import ir.maktab.homeserviceprovider.model.BaseModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Service")
@Getter
@Setter
public class ServiceModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Service-name cannot be null")
    private String name;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SubServiceModel> subServices = new HashSet<>();

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ExpertServiceModel> expertServices = new HashSet<>();

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

    @Override
    public String toString() {
        return "ServiceModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
