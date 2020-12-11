package com.arknights.service;

import java.util.List;
import com.arknights.pojo.GameImage;

public interface GameImageService {
	
	public int insert(GameImage gameImage);

	public void delete(GameImage gameImage);
	
	public int update(GameImage gameImage);

	public GameImage get(GameImage gameImage);

	public List<GameImage> list();

	public int count();
}
