package com.example.demo.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.Order_Repository;

@Service
public class OrderService {
	
private Order_Repository orderRep;

	
    @Autowired  //DI
	public OrderService(Order_Repository orderRep) 
	{
	this.orderRep = orderRep;
    }
    
	public List<Order>  displayAllData()
	{
		return orderRep.findAll();    
	}
	
	public Order selectBasedById(int o_id)
	{
		return orderRep.findById(o_id).get(); 
	}
	
	public void insorup(Order order)
	{
		orderRep.save(order);   
	}
	
	public void removebasedById(int o_id)
	{
		orderRep.deleteById(o_id); 
	}

}
