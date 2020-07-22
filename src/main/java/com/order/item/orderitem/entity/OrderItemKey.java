package com.order.item.orderitem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="order_id")
	int orderId ;
	
	@Column(name="product_code")
	int productCode ;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

}
