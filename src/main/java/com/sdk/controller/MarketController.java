package com.sdk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.domain.Market;
import com.sdk.service.MarketService;


@Controller  
@RequestMapping("/market")
public class MarketController {
	
	@Autowired
	private MarketService marketService;
	

	@GetMapping("/hello")
	public ModelAndView sayHi() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Hi");
		mav.addObject("messagebody","Welcome to SADIK BAKKAL");
		mav.setViewName("hi");
		return mav;
	}
	
	@GetMapping("/new")
	public String sendMarketForm(@ModelAttribute("market") Market market) {
		return "marketForm"; 
	}
	
	@PostMapping("/saveMarket")
	public String createMarket(@Valid @ModelAttribute Market market, BindingResult bindingResult) {
		//validation
		if(bindingResult.hasErrors()) {
			return "marketForm";
		}
		marketService.saveMarket(market);
		return "redirect:/market";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") Integer id, Model model) {
		Market market= marketService.findMarketById(id);
	    model.addAttribute("market",market);
	    return "marketForm";
	}
	
	@GetMapping("/delete")
	public String deleteMarket(@RequestParam("id") Integer id) {
		marketService.deleteMarket(id);
		return "redirect:/market";
	}
	
	
	@GetMapping
	public ModelAndView getMarket() {
		List<Market> list= marketService.getAllMarket();
		ModelAndView mav=new ModelAndView();
		mav.addObject("market",list);
		mav.setViewName("market");
		return mav;
	}
}
