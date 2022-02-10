package ir.maktab.homeserviceprovider.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ExpertServiceId implements Serializable {

    private Long expertId;
    private Long serviceId;

    public ExpertServiceId() {
    }

    public ExpertServiceId(Long expertId, Long serviceId) {
        this.expertId = expertId;
        this.serviceId = serviceId;
    }
}