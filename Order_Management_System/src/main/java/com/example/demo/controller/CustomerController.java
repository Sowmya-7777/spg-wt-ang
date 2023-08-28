package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;

import com.example.demo.serviceImplementations.CustomerService;

@RestController  
@Validated
@RequestMapping("/customer")  
public class CustomerController {
	

	private CustomerService custSer;

	@Autowired
	public CustomerController(CustomerService custSer) {
		super();
		this.custSer = custSer;
	}
	
	@GetMapping("/list")
	public List<Customer> getAllUsersData(){
	 return custSer.displayAllUserDetails();

}
	@GetMapping("/list/{customerId}")
	public Customer getUserData(@PathVariable("customerId") int c_id) {
		Customer user = custSer.selectById(c_id);
		if(user == null)
			throw new RuntimeException("user not found with this id..");
		return user;	
	}
	@PostMapping("/list")
	public String isertUser(@Valid @RequestBody Customer customer,BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getAllErrors()
					.stream()
					.map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());
			return errors.toString();
					
		}
		customer.setcId(0);
		 
		 return custSer.insorup(customer);
	}
	
	@PutMapping("/list")
	public void updateUser(@RequestBody Customer customer) {
		custSer.updateUser(customer);
	}
	
	@DeleteMapping("/list/{customerId}")
	public String deleteById(@PathVariable("customerId") int cId) {
		Customer user = custSer.selectById(cId);
		if(user ==null)
			throw new RuntimeException("user not found with this id..");
		custSer.removeById(cId);
		return "Deleted user id is "+ cId;
	}

}
