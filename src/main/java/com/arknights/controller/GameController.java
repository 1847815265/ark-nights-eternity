package com.arknights.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.arknights.pojo.Category;
import com.arknights.pojo.Game;
import com.arknights.pojo.GameImage;
import com.arknights.service.CategoryService;
import com.arknights.service.GameImageService;
import com.arknights.service.GameService;

@Controller
@RequestMapping("")
public class GameController {
	@Autowired
	GameService gameService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	GameImageService gameImageService;
	@RequestMapping("listGame")
	public ModelAndView listGame() {
		ModelAndView mav = new ModelAndView("listGame");
		List<Game> gameList = gameService.list();
		List<Category> categoryList = categoryService.list();
		List<GameImage> imageList = gameImageService.list();
		mav.addObject("gameList", gameList);
		mav.addObject("categoryList", categoryList);
		mav.addObject("imageList", imageList);
		return mav;
	}

	@RequestMapping("addGame")
	public ModelAndView addGame(Game game,BigDecimal category_id) {
		Category category = new Category();
		category.setCategory_id(category_id);
		game.setCategory(category);
		gameService.insert(game);
		ModelAndView mav = new ModelAndView("redirect:/listGame");
		return mav;
	}

	@RequestMapping("updateGame")
	public ModelAndView updateGame(Game game,BigDecimal category_id) {
		Category category = new Category();
		category.setCategory_id(category_id);
		game.setCategory(category);
		gameService.update(game);
		ModelAndView mav = new ModelAndView("redirect:/listGame");
		return mav;
	}

	@RequestMapping("deleteGame")
	public ModelAndView deleteGame(Game game) {
		gameService.delete(game);
		ModelAndView mav = new ModelAndView("redirect:/listGame");
		return mav;
	}

}