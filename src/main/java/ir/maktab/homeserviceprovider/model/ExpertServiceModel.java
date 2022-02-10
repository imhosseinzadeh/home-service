package ir.maktab.homeserviceprovider.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "ExpertService")
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

    @Override
    public ExpertServiceModelId getId() {
        return this.id;
    }

    public ExpertModel getExpert() {
        return expert;
    }
}