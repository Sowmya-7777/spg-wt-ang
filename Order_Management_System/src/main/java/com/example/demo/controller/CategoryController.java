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

import com.example.demo.entity.Category;
import com.example.demo.serviceImplementations.CategoryService;


@RestController   
@RequestMapping("/category")  
public class CategoryController {
	
	private CategoryService catSer;
	
	@Autowired  //DI
	public CategoryController(CategoryService catSer) 
	{
		this.catSer = catSer;
	}
		
	    @GetMapping("/list")   //localhost:8080/category/list
		public List<Category>   getAllCategoryData()
		{
			 List<Category> cat=catSer.displayAllUserDetails();
			 return cat;
		}
	    
	    @GetMapping("/list/{categoryId}")   //localhost:8080/category/list/id
	   	public Category  getCategoryData(@PathVariable("categoryId") int cat_id)
	   	{
	    	Category cat=catSer.selectById(cat_id);
	   		 if(cat==null)
	   			 throw new RuntimeException("Category not found with that pcId");
	   	  return cat;
	   	}
	    
	    @PostMapping("/list")
	    public void insertCategory(@RequestBody Category category)
	    {
	    	category.setCat_id(0);
	    	catSer.insorup(category);
	    }
	    
	    @PutMapping("/list")
	    public void updateCategory(@RequestBody Category category)
	    {
	    	catSer.insorup(category);
	    }
	    
	    @DeleteMapping("/list/{categoryId}")
	    public String deleteById(@PathVariable("categoryId") int cat_Id)
	    {
	    	Category cat=catSer.selectById(cat_Id);
	  		 if(cat==null)
	  			 throw new RuntimeException("Category not found with that pcid ...deletion not possible");
	  	 catSer.removeById(cat_Id);
	  	 return "Deleted Category id is "+cat_Id;
	    }



}
