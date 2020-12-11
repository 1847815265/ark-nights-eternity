package com.arknights.service;

import java.util.List;
import com.arknights.pojo.Cart;
import com.arknights.pojo.Customer;

public interface CartService {
	public int insert(Cart cart);

	public void delete(Cart cart);

	public Cart get(Cart cart);

	public int update(Cart cart);

	public List<Cart> list();

	public int count();
	
	public List<Cart> findByCustomer(Customer customer);
}
