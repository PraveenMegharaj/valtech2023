package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String string;
	private String city;
	private int zipcode;
	@OneToOne(targetEntity = Customer.class,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;

	public Address(String string, String city, int zipcode) {
		this.string = string;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Address() {
		super();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
