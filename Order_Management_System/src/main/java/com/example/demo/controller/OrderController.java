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

import com.example.demo.entity.Order;
import com.example.demo.serviceImplementations.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private OrderService orderSer;

	  @Autowired  //DI
	  public OrderController(OrderService orderSer) 
	{
		this.orderSer = orderSer;
	}
		
	    @GetMapping("/list")   
		public List<Order>   getAllProductData()
		{
			 List<Order> order=orderSer.displayAllData();
			 return order;
		}
	    
	    @GetMapping("/list/{productId}")  
	   	public Order  getProductData(@PathVariable("productId") int oId)
	   	{
	    	Order order=orderSer.selectBasedById(oId);
	   		 if(order==null)
	   			 throw new RuntimeException("Product not found with that pId");
	   	  return order;
	   	}
	    
	    @PostMapping("/list")
	    public void insertProduct(@RequestBody Order product)
	    {
	    	product.setP_id(0);
	    	orderSer.insorup(product);
	    }
	    
	    @PutMapping("/list")
	    public void updateProduct(@RequestBody Order product)
	    {
	    	orderSer.insorup(product);
	    }
	    
	    @DeleteMapping("/list/{orderId}")
	    public String deleteById(@PathVariable("orderId") int pId)
	    {
	    	Order pro=orderSer.selectBasedById(pId);
	  		 if(pro==null)
	  			 throw new RuntimeException("Product not found with that pid ...deletion not possible");
	  	 orderSer.removebasedById(pId);
	  	 return "Deleted Product id is "+pId;
	    }


}
