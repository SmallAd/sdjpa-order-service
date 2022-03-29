package guru.springframework.orderservice.domain;

import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof BaseEntity)) {return false;}

        BaseEntity o1 = (BaseEntity) o;

        if (!Objects.equals(id, o1.id)) {return false;}
        if (!Objects.equals(createdDate, o1.createdDate)) {return false;}
        return Objects.equals(lastModifiedDate, o1.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        return result;
    }
}
