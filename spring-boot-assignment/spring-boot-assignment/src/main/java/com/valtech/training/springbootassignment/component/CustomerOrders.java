package com.valtech.training.springbootassignment.component;

import java.util.Date;

//import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CustomerOrders {
	
	private long orderID;
	private long customerID;
	@Basic@Temporal(TemporalType.DATE)
	private java.util.Date orderDate;
	
	public CustomerOrders() {
	}
	
	public CustomerOrders(long orderID, long customerID, Date orderDate) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
	}

	public CustomerOrders(long customerID, Date orderDate) {
		super();
		this.customerID = customerID;
		this.orderDate = orderDate;
	}

	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "CustomerOrders [orderID=" + orderID + ", customerID=" + customerID + ", orderDate=" + orderDate + "]";
	}
	
	
	
}
