package ir.maktab.homeserviceprovider.model.service;

import ir.maktab.homeserviceprovider.model.BaseModel;
import ir.maktab.homeserviceprovider.model.user.ExpertModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "ExpertService")
@Getter
@Setter
public class ExpertServiceModel extends BaseModel<ExpertServiceModelId> {

    @EmbeddedId
    private ExpertServiceModelId id = new ExpertServiceModelId();

    @ManyToOne
    @MapsId("expertId")
    private ExpertModel expert;

    @ManyToOne
    @MapsId("serviceId")
    private ServiceModel service;

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