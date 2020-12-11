package com.arknights.provider;

import org.apache.ibatis.jdbc.SQL;
import com.arknights.pojo.Cart;
import com.arknights.pojo.Customer;

public class CartProvider {
	public String insert() {
		return new SQL() {
			{
				INSERT_INTO("cart");
				VALUES("cart_id", "cart_seq.nextval");
				VALUES("game_id", "#{game.game_id}");
				VALUES("customer_id", "#{customer_id}");
				VALUES("amount", "#{amount}");
			}
		}.toString();
	}

	public String delete(Cart cart) {
		return new SQL() {
			{
				DELETE_FROM("cart");
				WHERE("cart_id=#{cart_id}");
			}
		}.toString();
	}

	public String update(Cart cart) {
		return new SQL() {
			{
				UPDATE("cart");
				if (cart.getAmount() != null) {
					SET("amount=#{amount}");
				}if(cart.getGame() != null) {
					if (cart.getGame().getGame_id() != null) {
						SET("game_id=#{game.game_id}");
					}
				}
				if (cart.getCustomer_id() != null) {
					SET("customer_id=#{customer_id}");
				}
				WHERE("cart_id=#{cart_id}");
			}
		}.toString();
	}
	
	public String select(Cart cart) {
		return new SQL() {
			{
				SELECT("*");
				FROM("cart");
				WHERE("cart_id=#{cart_id}");
			}
		}.toString();
	}

	public String list() {
		return new SQL() {
			{
				SELECT("*");
				FROM("cart");
				ORDER_BY("cart_id");
			}
		}.toString();
	}
	
	public String findByCustomer(Customer customer) {
		return new SQL() {
			{
				SELECT("*");
				FROM("cart");
				WHERE("customer_id=#{customer_id}");
				ORDER_BY("cart_id");
			}
		}.toString();
	}
}
