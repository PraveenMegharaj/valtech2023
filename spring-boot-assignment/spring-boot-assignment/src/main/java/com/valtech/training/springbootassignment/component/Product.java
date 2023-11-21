package com.valtech.training.springbootassignment.component;

public class Product {
	
	private int productID;
	private String productName;
	private int productAmount;
	private int manufacturerID;
	
	public Product() {
	}
	
	public Product(int productID, String productName, int productAmount, int manufacturerID) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productAmount = productAmount;
		this.manufacturerID = manufacturerID;
	}

	public Product(String productName, int productAmount, int manufacturerID) {
		super();
		this.productName = productName;
		this.productAmount = productAmount;
		this.manufacturerID = manufacturerID;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public int getManufacturerID() {
		return manufacturerID;
	}
	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productAmount=" + productAmount
				+ ", manufacturerID=" + manufacturerID + "]";
	}
	
}
