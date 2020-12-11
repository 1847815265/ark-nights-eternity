package com.arknights.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.arknights.pojo.Customer;


public interface CustomerMapper {
	@Insert("insert into customer (customer_id,username,password,money )values(customer_seq.nextval,#{username},#{password},#{money})")
	public int add(Customer customer);

	@Delete("delete from customer where customer_id= #{customer_id}")
	public void delete(Customer customer);

	@Select("select * from customer where customer_id= #{customer_id}")
	public Customer get(Customer customer);
	
	@Select("select * from customer where username=#{username} and password=#{password}")
	public Customer findCustomerByUsernamePassword(Customer customer);

	@Update("update customer set username=#{username},password=#{password},money=#{money} where customer_id=#{customer_id}")
	public int update(Customer customer);

	@Select("select * from customer order by customer_id")
	public List<Customer> list();

	public int count();
	
	@Select("select * from customer where username=#{username}")
	public Customer findCustomerByUsername(Customer customer);

}
