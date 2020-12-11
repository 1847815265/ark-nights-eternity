package com.arknights.pojo;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class PropertyValue {
	//属性值id
	private BigDecimal propertyvalue_id;
	//游戏
	private Game game;
	//属性
	private Property property;
	//属性值
	private String proValue;
}
