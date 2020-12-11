package com.arknights.service;

import java.util.List;
import com.arknights.pojo.Game;

public interface GameService {
	List<Game> list();
	
	int insert(Game game);
	
	void delete(Game game); 
    
    Game get(Game game); 
    
    int update(Game game);  
     
    int count();

}
