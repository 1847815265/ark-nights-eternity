package com.arknights.pojo;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class GameImage {
	private BigDecimal gameImage_id;
	private BigDecimal game_id;
	private String img_url;
	private BigDecimal is_master;
	private BigDecimal img_order;
}
