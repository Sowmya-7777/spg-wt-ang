package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customised_Product")
public class Customised_Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cp_id")
	private int cp_id;
	@Column(name="budget")
	private double budget;
	@Column(name="thumbnail")
	private String thumbnail;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private double price;
	@Column(name="c_id")
	private int c_id;
	
//	@OneToOne(mappedBy = "customised_product", cascade = CascadeType.ALL)
//	private Customer customer;

	public Customised_Product() {
		super();
		
	}


	public Customised_Product(int cp_id, double budget, String thumbnail, String description, double price, int c_id,
			Customer customer) {
		super();
		this.cp_id = cp_id;
		this.budget = budget;
		this.thumbnail = thumbnail;
		this.description = description;
		this.price = price;
		this.c_id = c_id;
	//	this.customer = customer;
	}

	public int getCp_id() {
		return cp_id;
	}

	public void setCp_id(int cp_id) {
		this.cp_id = cp_id;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
//
//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	@Override
	public String toString() {
		return "Customised_Product [cp_id=" + cp_id + ", budget=" + budget + ", thumbnail=" + thumbnail
				+ ", description=" + description + ", price=" + price + ", c_id=" + c_id 
				+ "]";
	}

	

}
