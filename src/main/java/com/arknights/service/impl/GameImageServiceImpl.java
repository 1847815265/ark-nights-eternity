package com.arknights.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arknights.mapper.GameImageMapper;
import com.arknights.pojo.GameImage;
import com.arknights.service.GameImageService;
@Service
public class GameImageServiceImpl implements GameImageService {
	
	@Autowired
	GameImageMapper gameImageMapper;
	
	@Override
	public int insert(GameImage gameImage) {
		// TODO Auto-generated method stub
		return gameImageMapper.insert(gameImage);
	}

	@Override
	public void delete(GameImage gameImage) {
		// TODO Auto-generated method stub
		gameImageMapper.delete(gameImage);
	}

	@Override
	public int update(GameImage gameImage) {
		// TODO Auto-generated method stub
		return gameImageMapper.update(gameImage);
	}

	@Override
	public GameImage get(GameImage gameImage) {
		// TODO Auto-generated method stub
		return gameImageMapper.get(gameImage);
	}

	@Override
	public List<GameImage> list() {
		// TODO Auto-generated method stub
		return gameImageMapper.list();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
