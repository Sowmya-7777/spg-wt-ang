package com.example.demo.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customised_Product;

import com.example.demo.repository.Customised_Product_Repository;

@Service
public class CustomisedProductService {

private Customised_Product_Repository cProRep;
	
    @Autowired  //DI
	public CustomisedProductService(Customised_Product_Repository cProRep) 
	{
	this.cProRep = cProRep;
    }
	
	//to transfer data dao to controller
	public List<Customised_Product>  displayAllData()
	{
		return cProRep.findAll();     //select all the data from entity
	}
	
	public Customised_Product selectBasedById(int cp_id)
	{
		return cProRep.findById(cp_id).get(); //select data based on id
	}
	
	public void insorup(Customised_Product cProduct)
	{
		cProRep.save(cProduct);   //insert or update
	}
	
	public void removebasedById(int cp_id)
	{
		cProRep.deleteById(cp_id);  //deletion based on pk column
	}

}
