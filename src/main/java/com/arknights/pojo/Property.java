package com.arknights.pojo;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class Property {
	//属性id
	private BigDecimal property_id;
	//类别
	private Category category;
	//属性名
	private String name;
}
