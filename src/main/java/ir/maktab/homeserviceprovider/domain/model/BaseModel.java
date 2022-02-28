package ir.maktab.homeserviceprovider.domain.model;

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

    @Column(updatable = false)
    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public abstract I getId();

    public abstract void setId(I id);

    public boolean isNew() {
        return getId() == null;
    }

    @PrePersist
    public void onPersist() {
        createDate = updateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updateDate = LocalDateTime.now();
    }
}
