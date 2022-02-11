package ir.maktab.homeserviceprovider.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ExpertServiceModelId implements Serializable {
    private Long expertId;
    private Long serviceId;
}