package com.arknights.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arknights.mapper.CategoryMapper;
import com.arknights.pojo.Category;
import com.arknights.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryMapper categoryMapper;
	@Override
	public int insert(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(category);
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.delete(category);
	}

	@Override
	public Category get(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.get(category);
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.update(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryMapper.list();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
