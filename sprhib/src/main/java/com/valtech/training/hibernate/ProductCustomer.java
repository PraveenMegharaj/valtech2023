package com.valtech.training.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductCustomer {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String customerName;
	private int customerPhone;
	private String customerAddr;
	@OneToMany(targetEntity = ProductOrder.class,mappedBy = "productCustomer" )
	private List<ProductOrder> productOrders;
	
	public ProductCustomer() {
	}
	
	public ProductCustomer(String customerName, int customerPhone, String customerAddr) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddr = customerAddr;
	}

	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	public void setProductOrders(List<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}
	public List<ProductOrder> getProductOrders() {
		return productOrders;
	}
	public void addProductOrder(ProductOrder p) {
		if(getProductOrders() == null) {
			setProductOrders(new ArrayList<ProductOrder>());
		}
		getProductOrders().add(p);
		p.setProductCustomer(this);
	}

	@Override
	public String toString() {
		return "ProductCustomer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerAddr=" + customerAddr + ", productOrders=" + productOrders.size() + "]";
	}
	
	
	
	
}
