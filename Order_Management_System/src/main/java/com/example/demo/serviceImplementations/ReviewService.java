package com.example.demo.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Review;
import com.example.demo.repository.Review_Repository;

@Service
public class ReviewService {
	
	private Review_Repository revRep;

	 @Autowired  //DI
		public ReviewService(Review_Repository revRep) 
		{
		this.revRep = revRep;
	    }
		
		public List<Review>  displayAllData()
		{
			return revRep.findAll();     
		}
		
		public Review selectBasedById(int r_id)
		{
			return revRep.findById(r_id).get(); 
		}
		
		public void insorup(Review review)
		{
			revRep.save(review);  
		}
		
		public void removebasedById(int r_id)
		{
			revRep.deleteById(r_id);  
		}

}
