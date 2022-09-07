package com.ouhamza.ecommerce.dto;

import com.ouhamza.ecommerce.entity.Address;
import com.ouhamza.ecommerce.entity.Customer;
import com.ouhamza.ecommerce.entity.Order;
import com.ouhamza.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.List;

/**
 * @author <a href="https://github.com/ouhamzalhss"> Lhouceine OUHAMZA </a>
 */

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private List<OrderItem> orderItems;
	public Order getOrder() {
		// TODO Auto-generated method stub
		return order;
	}
	public List<OrderItem> getOrderItems() {
		// TODO Auto-generated method stub
		return orderItems;
	}
	public Address getBillingAddress() {
		// TODO Auto-generated method stub
		return billingAddress;
	}
	public Address getShippingAddress() {
		// TODO Auto-generated method stub
		return shippingAddress;
	}
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return customer;
	}
}

