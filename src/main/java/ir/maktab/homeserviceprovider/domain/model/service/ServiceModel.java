package ir.maktab.homeserviceprovider.domain.model.service;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Service")
@NoArgsConstructor
@Getter
@Setter
public class ServiceModel extends BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "ServiceModel-name cannot be blank")
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
