package com.valtech.training.hibernate;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductOrder {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
//	private long customerId;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "CustomerID",referencedColumnName = "customerId")
	private ProductCustomer productCustomer;
	
	public ProductOrder(java.util.Date date2) {
		this.date=(Date) date2;
	}
	
	
//	public ProductOrder(long customerId, LocalDate date) {
//		super();
//		this.customerId = customerId;
//		this.date = date;
//	}


	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
//	public long getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}
	public Date getDate() {
		return date;
	}
	public void setDate(DateFormat date) {
		date = date;
	}
	public ProductCustomer getProductCustomer() {
		return productCustomer;
	}
	public void setProductCustomer(ProductCustomer productCustomer) {
		this.productCustomer = productCustomer;
	}


	@Override
	public String toString() {
		return "ProductOrder [orderId=" + orderId + ", date=" + date + ", productCustomer=" + productCustomer.getCustomerName() + "]";
	}
	
	
}
