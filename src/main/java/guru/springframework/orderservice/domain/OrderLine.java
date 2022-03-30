package guru.springframework.orderservice.domain;

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

        if (quantityOrdered != null ? !quantityOrdered.equals(orderLine.quantityOrdered) : orderLine.quantityOrdered != null) {
            return false;
        }
        return orderHeader != null ? orderHeader.equals(orderLine.orderHeader) : orderLine.orderHeader == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (quantityOrdered != null ? quantityOrdered.hashCode() : 0);
        return result;
    }
}
