package ir.maktab.homeserviceprovider.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Entity
public class ExpertService implements BaseEntity<ExpertServiceId>, Serializable {

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

    public Expert getExpert() {
        return expert;
    }
}