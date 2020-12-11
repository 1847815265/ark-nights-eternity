package com.arknights.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.arknights.pojo.Cart;
import com.arknights.pojo.Customer;
import com.arknights.pojo.Game;
import com.arknights.service.CartService;
import com.arknights.service.CustomerService;
import com.arknights.service.GameService;

@Controller
@RequestMapping("")
public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	GameService gameService;
	@Autowired
	CustomerService customerService;

	@RequestMapping("cartShow")
	public ModelAndView cartShow(HttpSession session) {
		ModelAndView mav = new ModelAndView("cartShow");
		Customer customer = (Customer) session.getAttribute("LoginUser");
		List<Cart> checklist = cartService.findByCustomer(customer);
		for (Cart temp : checklist) {
			if (temp.getGame().getStock().compareTo(temp.getAmount()) < 0) {
				cartService.delete(temp);
			}
		}
		List<Cart> list = cartService.findByCustomer(customer);
		double sum = 0;
		for (Cart temp : list) {
			sum += (temp.getGame().getOriginalPrice().doubleValue() * temp.getAmount().doubleValue());
		}
		mav.addObject("list", list);
		mav.addObject("priceCount", sum);
		return mav;
	}

	@ResponseBody
	@RequestMapping("buyCheck")
	public String buyCheck(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("LoginUser");
		List<Cart> checklist = cartService.findByCustomer(customer);
		for (Cart temp : checklist) {
			if (temp.getGame().getStock().compareTo(temp.getAmount()) < 0) {
				cartService.delete(temp);
			}
		}
		List<Cart> list = cartService.findByCustomer(customer);
		BigDecimal sum = new BigDecimal(0);
		for (Cart temp : list) {
			sum = sum.add((temp.getGame().getOriginalPrice().multiply(temp.getAmount())));
		}
		if (sum.compareTo(customer.getMoney()) > 0) {
			return "2";
		} else {
			customer.setMoney(customer.getMoney().subtract(sum));
			customerService.update(customer);
			for (Cart temp : list) {
				temp.getGame().setStock(temp.getGame().getStock().subtract(temp.getAmount()));
				gameService.update(temp.getGame());
				cartService.delete(temp);
			}
			return "1";
		}
	}

	@RequestMapping("listCart")
	public ModelAndView listCart(HttpSession session) {

		ModelAndView mav = new ModelAndView("listCart");
		List<Cart> list = cartService.list();
		mav.addObject("list", list);
		return mav;
	}

	@ResponseBody
	@RequestMapping("insertCart")
	public String insertCart(HttpSession session, Game game, Cart inCart) {
		Customer customer = (Customer) session.getAttribute("LoginUser");
		inCart.setGame(game);
		inCart.setCustomer_id(customer.getCustomer_id());
		List<Cart> checklist = cartService.findByCustomer(customer);
		for (Cart cart : checklist) {
			if (game.getGame_id().compareTo(cart.getGame().getGame_id()) == 0) {
				cart.setAmount(cart.getAmount().add(inCart.getAmount()));
				cartService.update(cart);
				return "1";
			}
		}
		cartService.insert(inCart);
		return "1";
	}

	@RequestMapping("editCart")
	public ModelAndView editCart(Cart cart) {
		Cart g = cartService.get(cart);
		ModelAndView mav = new ModelAndView("updateCart");
		mav.addObject("cart", g);
		return mav;
	}

	@RequestMapping("updateCart")
	public ModelAndView updateCart(Cart cart) {
		cartService.update(cart);
		ModelAndView mav = new ModelAndView("redirect:/listCart");
		return mav;
	}

	@RequestMapping("deleteCart")
	public ModelAndView deleteCart(Cart cart) {
		cartService.delete(cart);
		ModelAndView mav = new ModelAndView("redirect:/listCart");
		return mav;
	}

}