package com.arknights.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
@Data
public class Review {
	private BigDecimal id;
	private String content;
	private Customer customer;
	private Game game;
	private Date createDate;
}
