package com.arknights.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.arknights.pojo.Category;
import com.arknights.pojo.Game;
import com.arknights.pojo.GameImage;
import com.arknights.service.CategoryService;
import com.arknights.service.GameImageService;
import com.arknights.service.GameService;

@Controller
@RequestMapping("")
public class GameImageController {
	@Autowired
	GameService gameService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	GameImageService gameImageService;
	
	@RequestMapping("listGameImage")
	public ModelAndView listGame() {
		ModelAndView mav = new ModelAndView("listGame");
		List<Game> gameList = gameService.list();
		List<Category> categoryList = categoryService.list();
		mav.addObject("gameList", gameList);
		mav.addObject("categoryList", categoryList);
		return mav;
	}

	@RequestMapping("addGameImage")
	@ResponseBody
	public String addGame(HttpServletRequest request,String game_id) {
		MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
		MultipartFile multipartFile = params.getFile("image");

		//起随机名
		String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName = "/static/img/gameimg/"+name + ".jpg";
        //连接文件存放路径并新建文件夹之后复制文件到指定文件夹
        File newFile = new File(request.getServletContext().getRealPath(""), newFileName);
        newFile.getParentFile().mkdirs();
        GameImage gameImage = new GameImage();
        gameImage.setGame_id(BigDecimal.valueOf(Integer.parseInt(game_id)));
        gameImage.setImg_url(newFileName);
        try {
        	multipartFile.transferTo(newFile);
        	gameImageService.insert(gameImage);
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "2";
		}
	}

	@RequestMapping("updateGameImage")
	public ModelAndView updateGame(Game game, BigDecimal category_id) {
		Category category = new Category();
		category.setCategory_id(category_id);
		game.setCategory(category);
		gameService.update(game);
		ModelAndView mav = new ModelAndView("redirect:/listGame");
		return mav;
	}

	@RequestMapping("deleteGameImage")
	public ModelAndView deleteGame(Game game) {
		gameService.delete(game);
		ModelAndView mav = new ModelAndView("redirect:/listGame");
		return mav;
	}
}
