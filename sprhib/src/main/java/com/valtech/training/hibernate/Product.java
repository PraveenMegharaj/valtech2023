package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
//	private String manufacturerId;
	private int amount;
	@ManyToOne(targetEntity = Company.class,fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "PRODUCT_ID",referencedColumnName = "companyID")
	private Company company;
	public Product() {
	}
	
	public Product(String productName, int amount) {
		super();
		this.productName = productName;
//		this.manufacturerId = manufacturerId;
		this.amount = amount;
	}

	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
//	public String getManufacturerId() {
//		return manufacturerId;
//	}
//	public void setManufacturerId(String manufacturerId) {
//		this.manufacturerId = manufacturerId;
//	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", amount=" + amount + ", company="
				+ company.getCompanyName() + "]";
	}
	
	
	
}
