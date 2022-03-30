package guru.springframework.orderservice.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class OrderLine extends BaseEntity {

    private Integer quantityOrdered;

    @ManyToOne
    private OrderHeader orderHeader;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof OrderLine)) {return false;}
        if (!super.equals(o)) {return false;}

        OrderLine orderLine = (OrderLine) o;

        if (!Objects.equals(quantityOrdered, orderLine.quantityOrdered)) {return false;}
        return Objects.equals(orderHeader, orderLine.orderHeader);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (quantityOrdered != null ? quantityOrdered.hashCode() : 0);
        result = 31 * result + (orderHeader != null ? orderHeader.hashCode() : 0);
        return result;
    }
}
