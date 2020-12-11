package com.arknights.service;

import java.util.List;
import com.arknights.pojo.Category;


public interface CategoryService {

	public int insert(Category category);
	
	public void delete(Category category);

	public Category get(Category category);
	
	public int update(Category category);

	public List<Category> list();

	public int count();
}
