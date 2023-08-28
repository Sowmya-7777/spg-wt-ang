package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="c_id")
	private int cId;
	
	@Column(name="c_name")
	//@NotBlank(message="Name is mandatory")
	private String cName;
	
	@Column(name="c_area")
	//@NotBlank(message="Area is mandatory")
	private String cArea;
	
	@Column(name="c_street")
	private String cStreet;
	
	@Column(name="c_city")
	//@NotBlank(message="City is mandatory")
	private String cCity;
	
	@Column(name="c_pin")
	private double cPin;
	
	@Column(name="c_phone")
	//@NotBlank(message="phone is mandatory")
	private String cPhone;
	
	@Column(name="c_birth")
	private String cBirth;
	
	@Column(name="c_email")
	//@NotBlank(message="email is mandatory")
	private String email;
	
	@Column(name="c_balance")
	private double cBalance;
	
//	@Column(name="o_id")
//	private int o_id;
	
	@Column(name="c_password")
	//@NotBlank(message="password is mandatory")
	@Size(min = 8, message = "Password should have at least 8 characters")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="Password should contain at least one lowercase letter, one uppercase letter, and one digit")
	private String cPassword; 
	
	
	public Customer() {
		super();
		
	}

	public Customer(int cId, @NotBlank(message = "Name is mandatory") String cName,
			@NotBlank(message = "Area is mandatory") String cArea, String cStreet,
			@NotBlank(message = "City is mandatory") String cCity, double cPin,
			@NotBlank(message = "phone is mandatory") String cPhone, String cBirth,
			@NotBlank(message = "email is mandatory") String email, double cBalance, int o_id,
			@NotBlank(message = "password is mandatory") @Size(min = 8, message = "Password should have at least 8 characters") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password should contain at least one lowercase letter, one uppercase letter, and one digit") String cPassword) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cArea = cArea;
		this.cStreet = cStreet;
		this.cCity = cCity;
		this.cPin = cPin;
		this.cPhone = cPhone;
		this.cBirth = cBirth;
		this.email = email;
		this.cBalance = cBalance;
		//this.o_id = o_id;
		this.cPassword = cPassword;
	}


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getcArea() {
		return cArea;
	}


	public void setcArea(String cArea) {
		this.cArea = cArea;
	}


	public String getcStreet() {
		return cStreet;
	}


	public void setcStreet(String cStreet) {
		this.cStreet = cStreet;
	}


	public String getcCity() {
		return cCity;
	}


	public void setcCity(String cCity) {
		this.cCity = cCity;
	}


	public double getcPin() {
		return cPin;
	}


	public void setcPin(double cPin) {
		this.cPin = cPin;
	}


	public String getcPhone() {
		return cPhone;
	}


	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}


	public String getcBirth() {
		return cBirth;
	}


	public void setcBirth(String cBirth) {
		this.cBirth = cBirth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}





	public String getcPassword() {
		return cPassword;
	}


	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public double getcBalance() {
		return cBalance;
	}

	public void setcBalance(double cBalance) {
		this.cBalance = cBalance;
	}

//	public int getO_id() {
//		return o_id;
//	}
//
//	public void setO_id(int o_id) {
//		this.o_id = o_id;
//	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cArea=" + cArea + ", cStreet=" + cStreet + ", cCity="
				+ cCity + ", cPin=" + cPin + ", cPhone=" + cPhone + ", cBirth=" + cBirth + ", email=" + email
				+ ", cBalance=" + cBalance+ ", cPassword=" + cPassword + "]";
	}


	
	
	
	

}
