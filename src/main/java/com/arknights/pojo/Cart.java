package com.arknights.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Cart {
	private BigDecimal Cart_id;
	private Game game;
	private BigDecimal customer_id;
	private BigDecimal amount;

}
