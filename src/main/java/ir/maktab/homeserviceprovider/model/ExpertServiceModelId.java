package ir.maktab.homeserviceprovider.model;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
@RequiredArgsConstructor
@AllArgsConstructor
public class ExpertServiceModelId implements Serializable {
    private Long expertId;
    private Long serviceId;
}