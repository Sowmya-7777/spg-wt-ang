package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Review")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="r_id")
	private int r_id;
	@Column(name="p_id")
	private int p_id;
	@Column(name="r_desc")
	private String r_desc;
	@Column(name="r_stars")
	private String r_stars;
	@Column(name="c_id")
	private int c_id;
	
	
//	@OneToOne(mappedBy = "review")
//	private Customer customer;
//
//	@ManyToOne(targetEntity=Product.class,fetch = FetchType.EAGER) 
//	@JoinColumn(name="p_id",insertable = false, updatable = false)
//	private Product product;
	
	public Review() {
		super();
	}


	/**
	 * @param r_id
	 * @param p_id
	 * @param r_desc
	 * @param r_stars
	 * @param c_id
	 */
	public Review(int r_id, int p_id, String r_desc, String r_stars, int c_id) {
		super();
		this.r_id = r_id;
		this.p_id = p_id;
		this.r_desc = r_desc;
		this.r_stars = r_stars;
		this.c_id = c_id;
	}


	public int getR_id() {
		return r_id;
	}


	public void setR_id(int r_id) {
		this.r_id = r_id;
	}


	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public String getR_desc() {
		return r_desc;
	}


	public void setR_desc(String r_desc) {
		this.r_desc = r_desc;
	}


	public String getR_stars() {
		return r_stars;
	}


	public void setR_stars(String r_stars) {
		this.r_stars = r_stars;
	}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	@Override
	public String toString() {
		return "Review [r_id=" + r_id + ", p_id=" + p_id + ", r_desc=" + r_desc + ", r_stars=" + r_stars + ", c_id="
				+ c_id + "]";
	}
   
	
	
}
