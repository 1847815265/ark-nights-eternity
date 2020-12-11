package com.arknights.pojo;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Game {
	// 游戏id
	private BigDecimal game_id;
	// 游戏名
	private String name;
	// 游戏描述
	private String subTitle;
	// 原价格
	private BigDecimal originalPrice;
	// 折后价
	private BigDecimal promotePrice;
	// 库存
	private BigDecimal stock;
	// 类别
	private Category category;
	// 创建日期
	private Date createDate;

}
