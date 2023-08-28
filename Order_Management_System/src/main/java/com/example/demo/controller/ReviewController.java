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
import com.example.demo.entity.Review;
import com.example.demo.serviceImplementations.ReviewService;

@RestController   
@RequestMapping("/review")  
public class ReviewController {
	
	private ReviewService revSer;

	  @Autowired  //DI
	  public ReviewController(ReviewService revSer) 
	{
		this.revSer = revSer;
	}
		
	    @GetMapping("/list")   
		public List<Review>  getAllProductData()
		{
			 List<Review> review=revSer.displayAllData();
			 return review;
		}
	    
	    @GetMapping("/list/{reviewId}")  
	   	public Review  getProductData(@PathVariable("reviewId") int rId)
	   	{
	    	Review review=revSer.selectBasedById(rId);
	   		 if(review==null)
	   			 throw new RuntimeException("Review not found with that pId");
	   	  return review;
	   	}
	    
	    @PostMapping("/list")
	    public void insertProduct(@RequestBody Review review)
	    {
	    	review.setR_id(0);
	    	revSer.insorup(review);
	    }
	    
	    @PutMapping("/list")
	    public void updateProduct(@RequestBody Review review)
	    {
	    	revSer.insorup(review);
	    }
	    
	    @DeleteMapping("/list/{reviewId}")
	    public String deleteById(@PathVariable("reviewId") int rId)
	    {
	    	Review review=revSer.selectBasedById(rId);
	  		 if(review==null)
	  			 throw new RuntimeException("Review not found with that pid ...deletion not possible");
	  	 revSer.removebasedById(rId);
	  	 return "Deleted Product id is "+rId;
	    }


}
