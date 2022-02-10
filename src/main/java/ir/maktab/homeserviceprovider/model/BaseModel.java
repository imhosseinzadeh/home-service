package ir.maktab.homeserviceprovider.model;

import java.io.Serializable;

public interface BaseModel<I extends Serializable> extends Serializable {
    I getId();
}