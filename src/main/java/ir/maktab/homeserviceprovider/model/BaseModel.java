package ir.maktab.homeserviceprovider.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class BaseModel<I extends Serializable> implements Serializable {

    @Version
    private Long version;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    abstract I getId();

    @PrePersist
    public void setCreateDate() {
        createDate = updateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateDate() {
        updateDate = LocalDateTime.now();
    }
}
