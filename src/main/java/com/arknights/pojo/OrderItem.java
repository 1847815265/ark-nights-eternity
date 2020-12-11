package com.arknights.pojo;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class OrderItem {
	private BigDecimal orderItem_id;
	private Game game;
	private Order order;
	private Customer customer;
	private BigDecimal amount;
}
