package com.arknights.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arknights.mapper.CartMapper;
import com.arknights.pojo.Cart;
import com.arknights.pojo.Customer;
import com.arknights.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartMapper cartMapper;

	@Override // 返回所有商品的列表
	public List<Cart> list() {
		// TODO Auto-generated method stub
		return cartMapper.list();
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		cartMapper.delete(cart);
	}

	@Override
	public Cart get(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.get(cart);
	}

	@Override
	public int update(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.update(cart);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return cartMapper.count();
	}

	@Override
	public int insert(Cart cart) {
		// TODO Auto-generated method stub
		return cartMapper.insert(cart);
	}

	@Override
	public List<Cart> findByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cartMapper.findByCustomer(customer);
	}

}
