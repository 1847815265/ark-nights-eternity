package com.arknights.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arknights.mapper.GameMapper;
import com.arknights.pojo.Game;
import com.arknights.service.GameService;

@Service
public class GameServiceImpl implements GameService{
	@Autowired
	GameMapper gameMapper;
	@Override//返回所有商品的列表
	public List<Game> list() {
		// TODO Auto-generated method stub
		return gameMapper.list();
	}
	@Override
	public int insert(Game game) {
		// TODO Auto-generated method stub
		return gameMapper.insert(game);
	}
	@Override
	public void delete(Game game) {
		// TODO Auto-generated method stub
		gameMapper.delete(game);
	}
	@Override
	public Game get(Game game) {
		// TODO Auto-generated method stub
		return gameMapper.get(game);
	}
	@Override
	public int update(Game game) {
		// TODO Auto-generated method stub
		return gameMapper.update(game);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return gameMapper.count();
	}

	
}
