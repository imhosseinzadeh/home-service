package ir.maktab.homeserviceprovider.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@SuperBuilder
@Data
public abstract class BaseDto<I extends Serializable> {
    private I id;

    public I getId() {
        return this.id;
    }
}
