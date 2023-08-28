package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="o_id")
	private int o_id;
	@Column(name="p_id")
	private int p_id;
	@Column(name="p_quantity")
	private int p_quantity;
	@Column(name="s_id")
	private int s_id;
	@Column(name="o_date")
	private String o_date;
	@Column(name="o_delivery")
	private String o_delivery;
	@Column(name="status")
	private String status;
	
	public Order() {
		super();

	}


	public Order(int o_id, int p_id, int p_quantity, int s_id, String o_date, String o_delivery, String status) {
		super();
		this.o_id = o_id;
		this.p_id = p_id;
		this.p_quantity = p_quantity;
		this.s_id = s_id;
		this.o_date = o_date;
		this.o_delivery = o_delivery;
		this.status = status;
	}


	public int getO_id() {
		return o_id;
	}


	public void setO_id(int o_id) {
		this.o_id = o_id;
	}


	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public int getP_quantity() {
		return p_quantity;
	}


	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}


	public int getS_id() {
		return s_id;
	}


	public void setStaff_id(int s_id) {
		this.s_id = s_id;
	}


	public String getO_date() {
		return o_date;
	}


	public void setO_date(String o_date) {
		this.o_date = o_date;
	}


	public String getO_delivery() {
		return o_delivery;
	}


	public void setO_delivery(String o_delivery) {
		this.o_delivery = o_delivery;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", p_id=" + p_id + ", p_quantity=" + p_quantity + ", s_id=" + s_id + ", o_date="
				+ o_date + ", o_delivery=" + o_delivery + ", status=" + status + "]";
	}


	
	

}
