package com.arknights.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.arknights.pojo.Category;
import com.arknights.provider.CategoryProvider;

public interface CategoryMapper {
	@InsertProvider(type=CategoryProvider.class,method="insert")
	//@Insert("insert into category (category_id,name,price,quantity )values(category_seq.nextval,#{name},#{price},#{quantity})")
	public int insert(Category category);
	
	@DeleteProvider(type=CategoryProvider.class,method="delete")
	//@Delete("delete from category where category_id= #{category_id}")
	public void delete(Category category);

	@SelectProvider(type=CategoryProvider.class,method="get")
	//@Select("select * from category where category_id= #{category_id}")
	public Category get(Category category);
	
	@UpdateProvider(type=CategoryProvider.class,method="update")
	//@Update("update category set name=#{name},price=#{price},quantity=#{quantity} where category_id=#{category_id}")
	public int update(Category category);

	@SelectProvider(type=CategoryProvider.class,method="list")
	//@Select("select * from category order by category_id")
	public List<Category> list();

	public int count();
}
