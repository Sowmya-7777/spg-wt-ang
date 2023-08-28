package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Customised_Product;
import com.example.demo.serviceImplementations.CustomisedProductService;

@RestController   
@RequestMapping("/customisedproduct")  
public class CustomisedProductController {
	
private CustomisedProductService cusSer;
	
	@Autowired  //DI
	public CustomisedProductController(CustomisedProductService cusSer) 
	{
		this.cusSer = cusSer;
	}
		
	    @GetMapping("/list") 
		public List<Customised_Product >  getAllCategoryData()
		{
			 List<Customised_Product> cat=cusSer.displayAllData();
			 return cat;
		}
	    
	    @GetMapping("/list/{customisedPId}")  
	   	public Customised_Product  getCategoryData(@PathVariable("customisedPId") int pcId)
	   	{
	    	Customised_Product cat=cusSer.selectBasedById(pcId);
	   		 if(cat==null)
	   			 throw new RuntimeException("Category not found with that pcId");
	   	  return cat;
	   	}
	    
	    @PostMapping("/list")
	    public void insertCategory(@RequestBody Customised_Product custPro)
	    {
	    	custPro.setC_id(0);
	    	cusSer.insorup(custPro);
	    }
	    
	    @PutMapping("/list")
	    public void updateCategory(@RequestBody Customised_Product custPro)
	    {
	    	cusSer.insorup(custPro);
	    }
	    
	    @DeleteMapping("/list/{customisedPId}")
	    public String deleteById(@PathVariable("customisedPId") int pcId)
	    {
	    	Customised_Product cat=cusSer.selectBasedById(pcId);
	  		 if(cat==null)
	  			 throw new RuntimeException("Category not found with that pcid ...deletion not possible");
	  	 cusSer.removebasedById(pcId);
	  	 return "Deleted Category id is "+pcId;
	    }


}
