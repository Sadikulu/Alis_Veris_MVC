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

import com.sdk.domain.Manav;
import com.sdk.domain.Market;
import com.sdk.domain.Sarkuteri;
import com.sdk.domain.Sepet;
import com.sdk.service.ManavService;
import com.sdk.service.MarketService;
import com.sdk.service.SarkuteriService;
import com.sdk.service.SepetService;


@Controller  
@RequestMapping("/sepet")
public class SepetController {
	
	@Autowired
	private SepetService sepetService;
	@Autowired
	private MarketService marketService;
	@Autowired
	private ManavService manavService;
	@Autowired
	private SarkuteriService sarkuteriService;
	
	
	@GetMapping("/new")
	public String sendSepetForm(@ModelAttribute("sepet") Sepet sepet,@RequestParam("id") Integer id, Model model) {
		Manav manav= manavService.findManavById(id);
	    model.addAttribute("manav",manav);
	    Market market= marketService.findMarketById(id);
	    model.addAttribute("market",market);
	    Sarkuteri sarkuteri= sarkuteriService.findSarkuteriById(id);
	    model.addAttribute("sarkuteri",sarkuteri);
		return "sepetForm"; 
	}
	
	@PostMapping("/saveSepet")
	public String createSepet(@Valid @ModelAttribute Sepet sepet, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "sepetForm";
		}
		sepetService.saveSepet(sepet);
		return "redirect:/sepet";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") Integer id, Model model) {
		Sepet sepet= sepetService.findSepetById(id);
	    model.addAttribute("sepet",sepet);
	    return "sepetForm";
	
	}
	
	@GetMapping("/delete")
	public String deleteSepet(@RequestParam("id") Integer id) {
		sepetService.deleteSepet(id);
		return "redirect:/sepet";
	}
	
	
	@GetMapping
	public ModelAndView getSepet() {
		List<Sepet> list= sepetService.getAllSepet();
		ModelAndView mav=new ModelAndView();
		mav.addObject("sepet",list);
		mav.setViewName("sepet");
		return mav;
	}
	
}
