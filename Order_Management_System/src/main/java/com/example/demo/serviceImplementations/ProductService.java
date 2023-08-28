package com.example.demo.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.Product_Repository;

@Service
public class ProductService {
	
private Product_Repository proRep;
	
    @Autowired  //DI
	public ProductService(Product_Repository proRep) 
	{
	this.proRep = proRep;
    }
    
	public List<Product>  displayAllData()
	{
		return proRep.findAll();    
	}
	
	public Product selectBasedById(int p_id)
	{
		return proRep.findById(p_id).get(); 
	}
	
	public void insorup(Product product)
	{
		proRep.save(product);   
	}
	
	public void removebasedById(int p_id)
	{
		proRep.deleteById(p_id); 
	}


}
