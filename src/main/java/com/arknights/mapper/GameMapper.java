package com.arknights.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.arknights.pojo.Game;
import com.arknights.provider.GameProvider;

public interface GameMapper {
	@InsertProvider(type=GameProvider.class,method="insert")
	//@Insert("insert into game (game_id,name,price,quantity )values(game_seq.nextval,#{name},#{price},#{quantity})")
	public int insert(Game game);
	
	@DeleteProvider(type=GameProvider.class,method="delete")
	//@Delete("delete from game where game_id= #{game_id}")
	public void delete(Game game);

	
	@SelectProvider(type=GameProvider.class,method="get")
	@Results({
		@Result(property = "category", column = "category_id", one = @One(select = "com.arknights.mapper.CategoryMapper.get"))})
	public Game get(Game game);
	
	@UpdateProvider(type=GameProvider.class,method="update")
	public int update(Game game);

	@SelectProvider(type=GameProvider.class,method="list")
	@Results({
		@Result(property = "category", column = "category_id", one = @One(select = "com.arknights.mapper.CategoryMapper.get"))})
	public List<Game> list();
	
	@SelectProvider(type=GameProvider.class,method="select")
	@Results({
		@Result(property = "category", column = "category_id", one = @One(select = "com.arknights.mapper.CategoryMapper.get"))})
	public List<Game> select(Game game);
	
	public int count();

}
