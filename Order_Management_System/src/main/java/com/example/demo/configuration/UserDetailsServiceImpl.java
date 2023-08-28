package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;


public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	  Customer user = customerRepo.findByEmail(email);
	  if(user != null) {
		  return new CustomUserDetails(user);
	  }
		throw new UsernameNotFoundException("User not available");
	}

}
