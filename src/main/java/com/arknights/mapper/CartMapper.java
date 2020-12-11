package com.arknights.mapper;

import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.arknights.pojo.Cart;
import com.arknights.pojo.Customer;
import com.arknights.provider.CartProvider;

public interface CartMapper {
	
	@InsertProvider(type = CartProvider.class, method = "insert")
	public int insert(Cart cart);

	@DeleteProvider(type = CartProvider.class, method = "delete")
	public void delete(Cart cart);

	@SelectProvider(type = CartProvider.class, method = "select")
	@Results({
			@Result(property = "game", column = "game_id", one = @One(select = "com.arknights.mapper.GameMapper.get"))})
	public Cart get(Cart cart);

	@SelectProvider(type = CartProvider.class, method = "findByCustomer")
	@Results({
			@Result(property = "game", column = "game_id", one = @One(select = "com.arknights.mapper.GameMapper.get"))})
	public List<Cart> findByCustomer(Customer customer);

	@UpdateProvider(type = CartProvider.class, method = "update")
	public int update(Cart cart);

	@SelectProvider(type = CartProvider.class, method = "list")
	@Results({
			@Result(property = "game", column = "game_id", one = @One(select = "com.arknights.mapper.GameMapper.get"))})
	public List<Cart> list();

	public int count();

}
