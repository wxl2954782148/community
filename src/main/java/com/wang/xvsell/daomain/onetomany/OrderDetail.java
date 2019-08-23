package com.wang.xvsell.daomain.onetomany;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_detail")
@Getter
@Setter
public class OrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_detail_id")
	private Long orderDetailId;
	
	@Column(name="product_name")
	private String productName;

	@Column(name="product_price")
	private BigDecimal productPrice;

	@Column(name="product_sum")
	private short productSum;
	
	@ManyToOne(targetEntity=Order.class)
	@JoinColumn(name="order_id",referencedColumnName="order_id")
	private Order order;
}
