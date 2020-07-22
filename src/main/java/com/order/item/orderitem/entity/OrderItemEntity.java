package com.order.item.orderitem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="order_items")
public class OrderItemEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId      
	OrderItemKey id ;
	
	@Column(name="product_name")
	  String productName;
	
	  int quantity;
	  
	  protected OrderItemEntity() {}

	public OrderItemEntity(OrderItemKey id, String productName, int quantity) {
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
	}

	public OrderItemKey getId() {
		return id;
	}

	public void setId(OrderItemKey id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemEntity [id=" + id + ", productName=" + productName + ", quantity=" + quantity + "]";
	}
	  
	  
}
