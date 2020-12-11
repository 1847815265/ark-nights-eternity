package com.arknights.provider;

import org.apache.ibatis.jdbc.SQL;
import com.arknights.pojo.Game;

public class GameProvider {
	public String insert(Game game) {
		return new SQL() {
			{
				INSERT_INTO("game");
				VALUES("game_id", "game_seq.nextval");
				if (game.getName() != null) {
					VALUES("name", "#{name}");
				}
				if (game.getSubTitle() != null) {
					VALUES("subTitle", "#{subTitle}");
				}
				if (game.getStock() != null) {
					VALUES("stock", "#{stock}");
				}
				if (game.getOriginalPrice() != null) {
					VALUES("originalPrice", "#{originalPrice}");
				}
				if (game.getPromotePrice() != null) {
					VALUES("promotePrice", "#{promotePrice}");
				}
				if (game.getCategory().getCategory_id() != null) {
					VALUES("category_id", "#{category.category_id}");
				}
				VALUES("createdate", "sysdate");
			}
		}.toString();
	}

	public String delete(Game game) {
		return new SQL() {
			{
				DELETE_FROM("game");
				WHERE("game_id=#{game_id}");
			}
		}.toString();
	}

	public String update(Game game) {
		return new SQL() {
			{
				UPDATE("game");
				if (game.getName() != null) {
					SET("name=#{name}");
				}
				if (game.getSubTitle() != null) {
					SET("subTitle=#{subTitle}");
				}
				if (game.getStock() != null) {
					SET("stock=#{stock}");
				}
				if (game.getOriginalPrice() != null) {
					SET("originalPrice=#{originalPrice}");
				}
				if (game.getPromotePrice() != null) {
					SET("promotePrice=#{promotePrice}");
				}
				if (game.getCategory() != null) {
					if (game.getCategory().getCategory_id() != null) {
						SET("category_id=#{category.category_id}");
					}
				}
				WHERE("game_id=#{game_id}");
			}
		}.toString();
	}

	public String list() {
		return new SQL() {
			{
				SELECT("*");
				FROM("game");
				ORDER_BY("game_id");
			}
		}.toString();
	}

	public String get() {
		return new SQL() {
			{
				SELECT("*");
				FROM("game");
				WHERE("game_id=#{game_id}");
				
			}
		}.toString();
	}

	public String select(Game game) {
		return new SQL() {
			{
				SELECT("*");
				FROM("game");
				if (game != null) {
					if (game.getName() != null) {
						WHERE("name=#{name}");
					}
					if (game.getSubTitle() != null) {
						WHERE("subTitle=#{subTitle}");
					}
					if (game.getStock() != null) {
						WHERE("stock=#{stock}");
					}
					if (game.getOriginalPrice() != null) {
						WHERE("originalPrice=#{originalPrice}");
					}
					if (game.getPromotePrice() != null) {
						WHERE("promotePrice=#{promotePrice}");
					}
					if (game.getCategory().getCategory_id() != null) {
						WHERE("category_id=#{category.category_id}");
					}
				}
			}
		}.toString();
	}
}
