package com.example.demo.configuration;

import java.util.List;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.demo.filter.CategoryFilter;
import com.example.demo.filter.CustomerFilter;
import com.example.demo.filter.ProductFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
	public UserDetailsService getUsersDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
    public DaoAuthenticationProvider getDaoAuthProvider() {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(getUsersDetailsService());
    	daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
    	return daoAuthenticationProvider;
    } 
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuthProvider());
	}
  
    
    @Override
   	protected void configure(HttpSecurity http) throws Exception{
          
    	 Filter productFilter = new ProductFilter();
         Filter customerFilter = new CustomerFilter();
         Filter categoryFilter = new CategoryFilter();
         http
   		.authorizeRequests()
   		.antMatchers("/admin/**").hasRole("ADMIN")
   		.antMatchers("/user/**").hasRole("USER")
   		.antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").loginProcessingUrl("/login")
   		.defaultSuccessUrl("/user/").and().csrf().disable()
//        
         .addFilterAfter(productFilter,BasicAuthenticationFilter.class )
         .addFilterAfter(categoryFilter, productFilter.getClass())
         .addFilterAfter(customerFilter, categoryFilter.getClass());
//         .httpBasic()
//          .and()
//          .csrf().disable()
//          .formLogin().disable(); // Disable form-based login
        
//         .authorizeRequests()
//             .anyRequest().authenticated()
//             .and()
//         .httpBasic()
//             .and()
         
         
         
   		
   	}
   
}
