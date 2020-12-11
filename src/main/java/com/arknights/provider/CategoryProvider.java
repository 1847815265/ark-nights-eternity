package com.arknights.provider;

import org.apache.ibatis.jdbc.SQL;
import com.arknights.pojo.Category;

public class CategoryProvider {
	public String insert(Category category) {
		return new SQL() {
			{
				INSERT_INTO("category");
				VALUES("category_id", "category_seq.nextval");
				VALUES("name", "#{name}");
			}
		}.toString();
	}

	public String delete(Category category) {
		return new SQL() {
			{
				DELETE_FROM("category");
				WHERE("category_id=#{category_id}");
			}
		}.toString();
	}

	public String update(Category category) {
		return new SQL() {
			{
				UPDATE("category");
				SET("name=#{name}");
				WHERE("category_id=#{category_id}");
			}
		}.toString();
	}

	public String list() {
		return new SQL() {
			{
				SELECT("*");
				FROM("category");
				ORDER_BY("category_id");
			}
		}.toString();
	}
	
	public String get() {
		return new SQL() {
			{
				SELECT("*");
				FROM("category");
				WHERE("category_id=#{category_id}");
			}
		}.toString();
	}
}
