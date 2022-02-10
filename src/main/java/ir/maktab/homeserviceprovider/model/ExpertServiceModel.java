package ir.maktab.homeserviceprovider.model;

import lombok.Getter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "ExpertService")
@Getter
public class ExpertServiceModel implements BaseModel<ExpertServiceModelId> {

    @EmbeddedId
    private ExpertServiceModelId id = new ExpertServiceModelId();

    @ManyToOne
    @MapsId("expertId")
    private ExpertModel expert;

    @ManyToOne
    @MapsId("serviceId")
    private ServiceModel service;

    private Integer score;

    private Integer experienceYears;

    public void setExpert(ExpertModel expert) {
        expert.getExpertServices().add(this);
        this.expert = expert;
    }

    public void setService(ServiceModel service) {
        service.getExpertServices().add(this);
        this.service = service;
    }
}