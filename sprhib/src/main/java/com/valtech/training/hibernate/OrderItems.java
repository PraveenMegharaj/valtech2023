package com.valtech.training.hibernate;

import javax.persistence.Entity;

@Entity
public class OrderItems {

	private long orderId;
	private long productId;
	private int productQuantity;
	
	public OrderItems() {
	}
	
	public OrderItems(int productQuantity) {
		super();
		this.productQuantity = productQuantity;
	}

	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
}
