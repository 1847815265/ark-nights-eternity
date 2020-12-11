package com.arknights.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
@Data
public class Order {
	private BigDecimal order_id;
	private String orderCode;
	private String address;
	private String post;
	private String receiver;
	private String mobile;
	private String userMessage;
	private Date createDate;
	private Date payDate;
	private Date deliveryDate ;
	private Date confirmDate;
	private Customer customer;
	private String status;
}
