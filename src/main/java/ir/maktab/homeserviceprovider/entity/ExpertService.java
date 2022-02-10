package ir.maktab.homeserviceprovider.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ExpertService implements BaseEntity<ExpertServiceId> {

    @EmbeddedId
    private ExpertServiceId id = new ExpertServiceId();

    @ManyToOne
    @MapsId("expertId")
    private Expert expert;

    @ManyToOne
    @MapsId("serviceId")
    private Service service;

    private Integer score;

    private Integer experienceYears;

    @Override
    public ExpertServiceId getId() {
        return this.id;
    }
}