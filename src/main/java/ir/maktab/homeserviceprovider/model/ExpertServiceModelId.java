package ir.maktab.homeserviceprovider.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExpertServiceModelId implements Serializable {

    private Long expertId;
    private Long serviceId;

    public ExpertServiceModelId() {
    }

    public ExpertServiceModelId(Long expertId, Long serviceId) {
        this.expertId = expertId;
        this.serviceId = serviceId;
    }
}