package guru.springframework.orderservice.domain;

import java.util.Objects;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class OrderHeader extends BaseEntity{

    private String customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof OrderHeader)) {return false;}
        if (!super.equals(o)) {return false;}

        OrderHeader o1 = (OrderHeader) o;

        return Objects.equals(customer, o1.customer);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
