package com.valtech.training.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyID;
	private String companyName;
	private String companyAddr;
	@OneToMany(targetEntity = Product.class,mappedBy = "company",fetch = FetchType.EAGER)
	private Set<Product> product;
	
	public Company() {
	}
	
	public Company(String companyName, String companyAddr) {
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

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> hashSet) {
		this.product = hashSet;
	}
	public void setCompanyId(int companyID) {
		this.companyID=companyID;
	}
	public void addProduct(Product product) {
		if(getProduct()==null) {
			setProduct(new HashSet<Product>());
		}
		getProduct().add(product);
		product.setCompany(this);
	}

	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", companyAddr=" + companyAddr
				+ ", product=" + product.size() + "]";
	}
	
	
}
