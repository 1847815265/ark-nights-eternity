package com.arknights.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.arknights.service.CartService;
import com.arknights.service.CategoryService;
import com.arknights.service.CustomerService;
import com.arknights.service.GameService;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CartService cartService;
	@Autowired
	GameService gameService;
	@Autowired
	CustomerService customerService;
	@Autowired
	CategoryService categoryService;
}
