package com.ouhamza.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="https://github.com/ouhamzalhss"> Lhouceine OUHAMZA </a>
 */
@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;

    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void add(OrderItem item){
        if(item != null){
            if(orderItems == null){
                orderItems = new ArrayList<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }

	public void setCustomer(Customer customer2) {
		// TODO Auto-generated method stub
		this.customer = customer2;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber2) {
		// TODO Auto-generated method stub
		this.orderTrackingNumber= orderTrackingNumber2;
	}

	public void setBillingAddress(Address billingAddress2) {
		// TODO Auto-generated method stub
		this.billingAddress = billingAddress2;
	}

	public void setShippingAddress(Address shippingAddress2) {
		// TODO Auto-generated method stub
		this.shippingAddress = shippingAddress2;
	}

}
