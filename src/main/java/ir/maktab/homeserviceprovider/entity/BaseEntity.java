package ir.maktab.homeserviceprovider.entity;

import java.io.Serializable;

public interface BaseEntity<I extends Serializable> extends Serializable {
    I getId();
}
