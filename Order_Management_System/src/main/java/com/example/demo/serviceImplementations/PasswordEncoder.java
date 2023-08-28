package com.example.demo.serviceImplementations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder {
	
	private final BCryptPasswordEncoder passwordEncoder;

	public PasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}
	
	 
    public String encode(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }
//    public String decode(String )

    public boolean matches(String plainPassword, String encodedPassword) {
        return passwordEncoder.matches(plainPassword, encodedPassword);
    }

     
}
