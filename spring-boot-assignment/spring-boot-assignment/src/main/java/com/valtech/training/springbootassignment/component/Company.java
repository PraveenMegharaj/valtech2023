package com.valtech.training.springbootassignment.component;

public class Company {
	
	private int companyID;
	private String companyName;
	private String companyAddr;

	public Company() {
	}
	
	public Company(int companyID, String companyName, String companyAddr) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.companyAddr = companyAddr;
	}
	
	public Company(String companyName, String companyAddr) {
		super();
		this.companyName = companyName;
		this.companyAddr = companyAddr;
	}

	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", companyAddr=" + companyAddr
				+ "]";
	}
	
}
