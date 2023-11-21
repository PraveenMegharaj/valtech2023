package com.valtech.training.springbootassignment.component;

public class Customer {
	
	private long customerID;
	private String customerName;
	private String customerPhone;
	private String customerAddr;
	
	public Customer() {	}
	
	public Customer(String customerName, String customerPhone, String customerAddr) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddr = customerAddr;
	}

	public Customer(long customerID, String customerName, String customerPhone, String customerAddr) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddr = customerAddr;
	}

	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerAddr=" + customerAddr + "]";
	}
	
	
}
