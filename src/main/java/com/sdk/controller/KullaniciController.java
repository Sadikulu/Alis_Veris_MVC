package com.sdk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sdk.domain.Kullanici;
import com.sdk.domain.Manav;
import com.sdk.domain.Market;
import com.sdk.domain.Sarkuteri;
import com.sdk.service.KullaniciService;
import com.sdk.service.ManavService;
import com.sdk.service.MarketService;
import com.sdk.service.SarkuteriService;

@Controller  
@RequestMapping("/kullanici")
public class KullaniciController {

	@Autowired
	private ManavService manavService;
	@Autowired
	private MarketService marketService;
	@Autowired
	private SarkuteriService sarkuteriService;
	@Autowired
	private KullaniciService kullaniciService;
	
	@GetMapping("/new")
	public String sendKullaniciForm(@ModelAttribute("kullanici") Kullanici kullanici) {
		return "kayitForm"; 
	}
	
	
	@PostMapping("/saveKullanici")
	public String createKullanici(@Valid @ModelAttribute Kullanici kullanici,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "kayitForm";
		}
			kullaniciService.saveKullanici(kullanici);
		    return "redirect:/kullanici";
	}
	
	@GetMapping
	public ModelAndView getKullanici() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("kullanici");
		return mav;
	}
	
	@GetMapping("/manav")
	public ModelAndView getManav() {
		List<Manav> list= manavService.getAllManav();
		ModelAndView mav=new ModelAndView();
		mav.addObject("manav",list);
		mav.setViewName("kullaniciManav");
		return mav;
	}
	
	@GetMapping("/market")
	public ModelAndView getMarket() {
		List<Market> list= marketService.getAllMarket();
		ModelAndView mav=new ModelAndView();
		mav.addObject("market",list);
		mav.setViewName("kullaniciMarket");
		return mav;
	}
	
	@GetMapping("/sarkuteri")
	public ModelAndView getSarkuteri() {
		List<Sarkuteri> list= sarkuteriService.getAllSarkuteri();
		ModelAndView mav=new ModelAndView();
		mav.addObject("sarkuteri",list);
		mav.setViewName("kullaniciSarkuteri");
		return mav;
	}
	
	@GetMapping("/enter")
	public String enterKullaniciForm(@ModelAttribute("kullanici") Kullanici kullanici) {
		return "kullaniciForm"; 
	}
	
	@PostMapping("/enterKullanici")
	public String enterKullanici(@ModelAttribute Kullanici kullanici, String username, String password) {
		List<String> listUsername= kullaniciService.getkullaniciUserName();
		List<String> listPassword= kullaniciService.getKullaniciPassword();
		
		if(listUsername.contains(username) && listPassword.contains(password)) {
			return "redirect:/kullanici";
		}
		else {
			return "redirect:/kullanici/new";
		}
	}
}
