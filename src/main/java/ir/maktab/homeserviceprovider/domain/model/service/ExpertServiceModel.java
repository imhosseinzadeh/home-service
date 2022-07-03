package ir.maktab.homeserviceprovider.domain.model.service;

import ir.maktab.homeserviceprovider.domain.model.BaseModel;
import ir.maktab.homeserviceprovider.domain.model.user.ExpertModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "\"ExpertService\"")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpertServiceModel extends BaseModel<ExpertServiceModelId> {

    @EmbeddedId
    private ExpertServiceModelId id = new ExpertServiceModelId();

    @ManyToOne
    @MapsId("expertId")
    @NotNull(message = "ExpertServiceModel-expert can not be null")
    private ExpertModel expert;

    @ManyToOne
    @MapsId("serviceId")
    @NotNull(message = "ExpertServiceModel-service can not be null")
    private ServiceModel service;

    @PositiveOrZero(message = "ExpertServiceModel-experienceYears must be positive or zero")
    private Integer experienceYears;

    private Integer score;

    public void setExpert(ExpertModel expert) {
        expert.getExpertServices().add(this);
        this.expert = expert;
    }

    public void setService(ServiceModel service) {
        service.getExpertServices().add(this);
        this.service = service;
    }

    @Override
    public String toString() {
        return "ExpertService{" +
                "id=" + id +
                ", expert=" + expert +
                ", service=" + service +
                ", score=" + score +
                ", experienceYears=" + experienceYears +
                '}';
    }
}