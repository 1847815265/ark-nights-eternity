package com.arknights.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.arknights.pojo.GameImage;
import com.arknights.provider.GameImageProvider;

public interface GameImageMapper {
	
	@InsertProvider(type = GameImageProvider.class, method = "insert")
	public int insert(GameImage gameImage);

	@DeleteProvider(type = GameImageProvider.class, method = "delete")
	public void delete(GameImage gameImage);
	
	@UpdateProvider(type = GameImageProvider.class, method = "update")
	public int update(GameImage gameImage);
	
	@SelectProvider(type = GameImageProvider.class, method = "get")
	public GameImage get(GameImage gameImage);

	@SelectProvider(type = GameImageProvider.class, method = "list")
	public List<GameImage> list();

	public int count();
}
