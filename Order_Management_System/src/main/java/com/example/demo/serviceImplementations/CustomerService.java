package com.example.demo.serviceImplementations;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;



@Service
public class CustomerService {
	
private CustomerRepository custRepo;
	
	@Autowired  //DI
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	public CustomerService(CustomerRepository custRepo) {
		super();
		this.custRepo = custRepo;
	}
	@Transactional
	public List<Customer> displayAllUserDetails(){
		 List<Customer>customer = custRepo.findAll();
		 return customer;
	}
	@Transactional
	public Customer selectById(int c_id) {
		Customer customer = custRepo.findById(c_id).get();
		return customer;
	}
	@Transactional
	public String insorup(Customer customer) {
		Customer userFromDB=custRepo.findByEmail(customer.getEmail());
		if(userFromDB !=null) {
			return "This email already exists..";
	}
		customer.setcPassword(passwordEncoder.encode(customer.getcPassword()));
		
		custRepo.save(customer);
	return "Success";
}
	@Transactional
	public void removeById(int c_id) {
		custRepo.deleteById(c_id);
	}
	
	@Transactional
	public void updateUser(Customer customer) {
		custRepo.save(customer);
	}
	
//	@Transactional
//	public List<Customer> getUsersByQualification(String qualification){
//		return custRepo.findByQualification(qualification);
//	}
//	@Transactional
//	public List<Users> getUsersByRole(String role){
//		return userRepo.findByRole(role);
//	}

}
