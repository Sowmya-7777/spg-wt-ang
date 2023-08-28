package com.example.demo.serviceImplementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.Category_Repository;

@Service
public class CategoryService {
	
private Category_Repository catRepo;
	
	
	@Autowired
	public CategoryService(Category_Repository catRepo) {
		super();
		this.catRepo = catRepo;
	}
	@Transactional
	public List<Category> displayAllUserDetails(){
		 List<Category> category = catRepo.findAll();
		 return category;
	}
	@Transactional
	public Category selectById(int cat_id) {
		Category category = catRepo.findById(cat_id).get();
		return category;
	}
	@Transactional
	public void insorup(Category category) {
		
		
	 catRepo.save(category);
}
	@Transactional
	public void removeById(int cat_id) {
		catRepo.deleteById(cat_id);
	}
	
	@Transactional
	public void updateUser(Category customer) {
		catRepo.save(customer);
	}

}
