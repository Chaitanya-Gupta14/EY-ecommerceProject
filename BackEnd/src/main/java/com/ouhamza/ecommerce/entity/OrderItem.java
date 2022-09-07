package com.ouhamza.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author <a href="https://github.com/ouhamzalhss"> Lhouceine OUHAMZA </a>
 */

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private BigDecimal unitPrice;

    private int quantity;

    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public void setOrder(Order order2) {
		// TODO Auto-generated method stub
		this.order = order2;
	}


}
