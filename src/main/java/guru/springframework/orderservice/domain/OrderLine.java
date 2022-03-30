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

    @ManyToOne
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof OrderLine)) {return false;}
        if (!super.equals(o)) {return false;}

        OrderLine orderLine = (OrderLine) o;

        if (!Objects.equals(quantityOrdered, orderLine.quantityOrdered)) {return false;}
        if (!Objects.equals(orderHeader, orderLine.orderHeader)) {return false;}
        return Objects.equals(product, orderLine.product);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (quantityOrdered != null ? quantityOrdered.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
