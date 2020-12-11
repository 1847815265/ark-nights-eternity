package com.arknights.pojo;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Customer {
	// 顾客id
	private BigDecimal customer_id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 余额
	private BigDecimal money;

}
