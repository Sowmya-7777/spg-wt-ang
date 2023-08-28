package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p_id")
	private int p_id;
	@Column(name="p_name")
	private String p_name;
	@Column(name="p_thunmnail")
	private String p_thunmnail;
	@Column(name="p_price")
	private double p_price;
	@Column(name="p_details")
	private String p_details;
	@Column(name="p_quantity")
	private int p_quantity;
	@Column(name="cat_id")
	private int cat_id;

//	@ManyToOne(targetEntity=Category.class,fetch = FetchType.EAGER) 
//	@JoinColumn(name="cat_id",insertable = false, updatable = false)
//	private Category category;

//	@ManyToOne(targetEntity=Order.class,fetch = FetchType.EAGER) 
//	//@JoinColumn(name="p_id",insertable = false, updatable = false)
//	private Order order;

//	@ManyToOne(targetEntity=Category.class,fetch = FetchType.EAGER) 
//	@JoinColumn(name="pc_id",insertable = false, updatable = false)
//	private Review review;
	
//	@OneToMany(mappedBy = "product", cascade=CascadeType.ALL)
//	@JoinColumn(name="p_id",insertable = false, updatable = false)
//	private Order order;
//	
//	@OneToMany(mappedBy= "product", cascade=CascadeType.ALL)
//	private Review review;
	
	public Product() {
		super();
		
	}

public Product(int p_id, String p_name, String p_thunmnail, double p_price, String p_details, int p_quantity,
		int cat_id) {
	super();
	this.p_id = p_id;
	this.p_name = p_name;
	this.p_thunmnail = p_thunmnail;
	this.p_price = p_price;
	this.p_details = p_details;
	this.p_quantity = p_quantity;
	this.cat_id = cat_id;
}

public int getP_id() {
	return p_id;
}

public void setP_id(int p_id) {
	this.p_id = p_id;
}

public String getP_name() {
	return p_name;
}

public void setP_name(String p_name) {
	this.p_name = p_name;
}

public String getP_thunmnail() {
	return p_thunmnail;
}

public void setP_thunmnail(String p_thunmnail) {
	this.p_thunmnail = p_thunmnail;
}

public double getP_price() {
	return p_price;
}

public void setP_price(double p_price) {
	this.p_price = p_price;
}

public String getP_details() {
	return p_details;
}

public void setP_details(String p_details) {
	this.p_details = p_details;
}

public int getP_quantity() {
	return p_quantity;
}

public void setP_quantity(int p_quantity) {
	this.p_quantity = p_quantity;
}

public int getCat_id() {
	return cat_id;
}

public void setCat_id(int cat_id) {
	this.cat_id = cat_id;
}

@Override
public String toString() {
	return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_thunmnail=" + p_thunmnail + ", p_price=" + p_price
			+ ", p_details=" + p_details + ", p_quantity=" + p_quantity + ", cat_id=" + cat_id + "]";
}
	
	
	
}
