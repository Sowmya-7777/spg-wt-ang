package com.example.demo.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Staff;
import com.example.demo.repository.Staff_Repository;

@Service
public class StaffService {
	
	private Staff_Repository staffRep;

	 @Autowired  //DI
		public StaffService(Staff_Repository staffRep) 
		{
		this.staffRep = staffRep;
	    }
		
		public List<Staff>  displayAllData()
		{
			return staffRep.findAll();     
		}
		
		public Staff selectBasedById(int s_id)
		{
			return staffRep.findById(s_id).get(); 
		}
		
		public void insorup(Staff staff)
		{
			staffRep.save(staff);  
		}
		
		public void removebasedById(int s_id)
		{
			staffRep.deleteById(s_id);  
		}

}
