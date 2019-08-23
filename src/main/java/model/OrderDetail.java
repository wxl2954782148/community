package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the order_detail database table.
 * 
 */
@Entity
@Table(name="order_detail")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_detail_id")
	private String orderDetailId;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_price")
	private BigDecimal productPrice;

	@Column(name="product_sum")
	private short productSum;

	//bi-directional many-to-one association to OrderMaster
	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderMaster orderMaster;

	public OrderDetail() {
	}

	public String getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public short getProductSum() {
		return this.productSum;
	}

	public void setProductSum(short productSum) {
		this.productSum = productSum;
	}

	public OrderMaster getOrderMaster() {
		return this.orderMaster;
	}

	public void setOrderMaster(OrderMaster orderMaster) {
		this.orderMaster = orderMaster;
	}

}