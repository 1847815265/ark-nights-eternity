package com.arknights.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arknights.mapper.CustomerMapper;
import com.arknights.pojo.Customer;
import com.arknights.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerMapper customerMapper;
	@Override//返回所有商品的列表
	public List<Customer> list() {
		// TODO Auto-generated method stub
		return customerMapper.list();
	}
	@Override
	public int add(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.add(customer);
	}
	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.delete(customer);
	}
	@Override
	public Customer get(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.get(customer);
	}
	@Override
	public int update(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.update(customer);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return customerMapper.count();
	}
	@Override
	public Customer findCustomerByUsernamePassword(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.findCustomerByUsernamePassword(customer);
	}
	@Override
	public Customer findCustomerByUsername(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.findCustomerByUsername(customer);
	}
	
	
}
