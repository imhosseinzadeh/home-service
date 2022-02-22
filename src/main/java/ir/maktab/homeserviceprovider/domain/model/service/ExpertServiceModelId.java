package ir.maktab.homeserviceprovider.domain.model.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ExpertServiceModelId implements Serializable {
    private Long expertId;
    private Long serviceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpertServiceModelId that = (ExpertServiceModelId) o;
        return Objects.equals(expertId, that.expertId) && Objects.equals(serviceId, that.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expertId, serviceId);
    }
    
}