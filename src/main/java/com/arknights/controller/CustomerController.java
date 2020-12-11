package com.arknights.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.arknights.pojo.Customer;
import com.arknights.pojo.Game;
import com.arknights.service.CustomerService;
import com.arknights.service.GameService;

@Controller
@RequestMapping("")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@Autowired
	GameService gameService;

	@RequestMapping("listCustomer")
	public ModelAndView listcustomer() {
		ModelAndView mav = new ModelAndView("listcustomer");
		List<Customer> list = customerService.list();
		mav.addObject("list", list);
		return mav;
	}
	@ResponseBody
	@RequestMapping("addCustomer")
	public String addcustomer(@RequestBody Customer customer) {
		Customer cusCheck = customerService.findCustomerByUsername(customer);
		if(cusCheck!=null) {
			return "2";
		}else {
			customer.setMoney(new BigDecimal(10000));
			customerService.add(customer);
			return "1";
		}	
	}

	@RequestMapping("editCustomer")
	public ModelAndView editcustomer(Customer customer) {
		Customer g = customerService.get(customer);
		ModelAndView mav = new ModelAndView("updatecustomer");
		mav.addObject("customer", g);
		return mav;
	}

	@RequestMapping("updateCustomer")
	public ModelAndView updatecustomer(Customer customer) {
		customerService.update(customer);
		ModelAndView mav = new ModelAndView("redirect:/listcustomer");
		return mav;
	}

	@RequestMapping("deleteCustomer")
	public ModelAndView deletecustomer(Customer customer) {
		customerService.delete(customer);
		ModelAndView mav = new ModelAndView("redirect:/listcustomer");
		return mav;
	}

	@RequestMapping("gameShow")
	public ModelAndView gameShow() {
		ModelAndView mav = new ModelAndView("gameShow");
		List<Game> list = gameService.list();
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("resiste")
	public ModelAndView resiste() {
		ModelAndView mav = new ModelAndView("resiste");
		return mav;
	}
	
	@RequestMapping("backLoginPage")
	public ModelAndView backLoginPage(Customer customer) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@ResponseBody
	@RequestMapping("loginCheck")
	public String loginCheck(@RequestBody Customer checkUser, HttpSession session) {
		Customer getUser = customerService.findCustomerByUsername(checkUser);
		if (getUser != null) {
			if (getUser.getPassword().equals(checkUser.getPassword())) {
				session.setAttribute("LoginUser", getUser);
				return "3";
			} else {
				return "2";
			}
		} else {
			return "1";
		}
	}
}