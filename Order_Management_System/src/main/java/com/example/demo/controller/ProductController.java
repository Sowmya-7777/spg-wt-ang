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

import com.example.demo.entity.Product;
import com.example.demo.serviceImplementations.ProductService;

@RestController   
@RequestMapping("/product")  
public class ProductController {
	
	private ProductService proSer;

	  @Autowired  //DI
	  public ProductController(ProductService proSer) 
	{
		this.proSer = proSer;
	}
		
	    @GetMapping("/list")   
		public List<Product>   getAllProductData()
		{
			 List<Product> product=proSer.displayAllData();
			 return product;
		}
	    
	    @GetMapping("/list/{productId}")  
	   	public Product  getProductData(@PathVariable("productId") int pId)
	   	{
	    	Product pro=proSer.selectBasedById(pId);
	   		 if(pro==null)
	   			 throw new RuntimeException("Product not found with that pId");
	   	  return pro;
	   	}
	    
	    @PostMapping("/list")
	    public void insertProduct(@RequestBody Product product)
	    {
	    	product.setP_id(0);
	    	proSer.insorup(product);
	    }
	    
	    @PutMapping("/list")
	    public void updateProduct(@RequestBody Product product)
	    {
	    	proSer.insorup(product);
	    }
	    
	    @DeleteMapping("/list/{productId}")
	    public String deleteById(@PathVariable("productId") int pId)
	    {
	    	Product pro=proSer.selectBasedById(pId);
	  		 if(pro==null)
	  			 throw new RuntimeException("Product not found with that pid ...deletion not possible");
	  	 proSer.removebasedById(pId);
	  	 return "Deleted Product id is "+pId;
	    }


}
