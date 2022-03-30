package guru.springframework.orderservice.domain;

import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AttributeOverrides({
        @AttributeOverride(
                name = "shippingAddress.address",
                column = @Column(name = "shipping_address")
        ),
        @AttributeOverride(
                name = "shippingAddress.city",
                column = @Column(name = "shipping_city")
        ),
        @AttributeOverride(
                name = "shippingAddress.state",
                column = @Column(name = "shipping_state")
        ),
        @AttributeOverride(
                name = "shippingAddress.zipCode",
                column = @Column(name = "shipping_zip_code")
        ),
        @AttributeOverride(
                name = "billingAddress.address",
                column = @Column(name = "bill_to_address")
        ),
        @AttributeOverride(
                name = "billingAddress.city",
                column = @Column(name = "bill_to_city")
        ),
        @AttributeOverride(
                name = "billingAddress.state",
                column = @Column(name = "bill_to_state")
        ),
        @AttributeOverride(
                name = "billingAddress.zipCode",
                column = @Column(name = "bill_to_zip_code")
        ),
})
public class OrderHeader extends BaseEntity {

    private String customer;

    @Embedded
    private Address shippingAddress;

    @Embedded
    private Address billingAddress;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "orderHeader")
    @ToString.Exclude
    private Set<OrderLine> orderLines;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof OrderHeader)) {return false;}
        if (!super.equals(o)) {return false;}

        OrderHeader o1 = (OrderHeader) o;

        if (!Objects.equals(customer, o1.customer)) {return false;}
        if (!Objects.equals(shippingAddress, o1.shippingAddress)) {return false;}
        if (!Objects.equals(billingAddress, o1.billingAddress)) {return false;}
        if (orderStatus != o1.orderStatus) {return false;}
        return Objects.equals(orderLines, o1.orderLines);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (orderLines != null ? orderLines.hashCode() : 0);
        return result;
    }

}
