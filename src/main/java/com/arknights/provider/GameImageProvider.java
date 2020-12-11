package com.arknights.provider;

import org.apache.ibatis.jdbc.SQL;
import com.arknights.pojo.GameImage;

public class GameImageProvider {
	public String insert() {
		return new SQL() {
			{
				INSERT_INTO("gameImage");
				VALUES("gameImage_id", "gameImage_seq.nextval");
				VALUES("game_id", "#{game_id}");
				VALUES("img_url", "#{img_url}");
			}
		}.toString();
	}

	public String delete(GameImage gameImage) {
		return new SQL() {
			{
				DELETE_FROM("gameImage");
				WHERE("gameImage_id=#{gameImage_id}");
			}
		}.toString();
	}

	public String update(GameImage gameImage) {
		return new SQL() {
			{
				UPDATE("gameImage");
				if (gameImage.getGameImage_id() != null) {
					SET("gameImage_id=#{gameImage_id}");
				}
				if (gameImage.getGame_id() != null) {
					SET("game_id=#{game_id}");
				}
				if (gameImage.getImg_url() != null) {
					SET("img_url=#{img_url}");
				}
				if (gameImage.getIs_master() != null) {
					SET("is_master=#{is_master}");
				}
				if (gameImage.getImg_order() != null) {
					SET("img_order=#{img_order}");
				}
				WHERE("gameImage_id=#{gameImage_id}");
			}
		}.toString();
	}

	public String get(GameImage gameImage) {
		return new SQL() {
			{
				SELECT("*");
				FROM("gameImage");
				WHERE("gameImage_id=#{gameImage_id}");
			}
		}.toString();
	}

	public String list() {
		return new SQL() {
			{
				SELECT("*");
				FROM("gameImage");
				ORDER_BY("gameImage_id");
			}
		}.toString();
	}

}
