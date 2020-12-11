package com.arknights.service;

import java.util.List;
import com.arknights.pojo.Customer;

public interface CustomerService {
	List<Customer> list();

	int add(Customer customer);

	void delete(Customer customer);

	Customer get(Customer customer);

	Customer findCustomerByUsernamePassword(Customer customer);

	int update(Customer customer);

	int count();

	Customer findCustomerByUsername(Customer customer);
}


