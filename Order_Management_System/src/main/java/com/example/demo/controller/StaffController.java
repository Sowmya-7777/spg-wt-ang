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

import com.example.demo.entity.Staff;
import com.example.demo.serviceImplementations.StaffService;

@RestController   
@RequestMapping("/staff") 
public class StaffController {

	private StaffService staffSer;

	  @Autowired  //DI
	  public StaffController(StaffService staffSer) 
	{
		this.staffSer = staffSer;
	}
		
	    @GetMapping("/list")   
		public List<Staff>  getAllProductData()
		{
			 List<Staff> staff=staffSer.displayAllData();
			 return staff;
		}
	    
	    @GetMapping("/list/{staffId}")  
	   	public Staff  getProductData(@PathVariable("staffId") int s_Id)
	   	{
	    	Staff staff=staffSer.selectBasedById(s_Id);
	   		 if(staff==null)
	   			 throw new RuntimeException("Review not found with that pId");
	   	  return staff;
	   	}
	    
	    @PostMapping("/list")
	    public void insertProduct(@RequestBody Staff staff)
	    {
	    	staff.setS_id(0);
	    	staffSer.insorup(staff);
	    }
	    
	    @PutMapping("/list")
	    public void updateProduct(@RequestBody Staff staff)
	    {
	    	staffSer.insorup(staff);
	    }
	    
	    @DeleteMapping("/list/{staffId}")
	    public String deleteById(@PathVariable("staffId") int sId)
	    {
	    	Staff staff=staffSer.selectBasedById(sId);
	  		 if(staff==null)
	  			 throw new RuntimeException("Staff not found with that pid ...deletion not possible");
	  	 staffSer.removebasedById(sId);
	  	 return "Deleted Product id is "+sId;
	    }
}
