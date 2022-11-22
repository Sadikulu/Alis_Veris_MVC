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

import com.sdk.service.ManavService;


@Controller  
@RequestMapping("/manav")
public class ManavController {
	
	@Autowired
	private ManavService manavService;
	

	@GetMapping("/hello")
	public ModelAndView sayHi() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Hi");
		mav.addObject("messagebody","Welcome to SADIK BAKKAL");
		mav.setViewName("hi");
		return mav;
	}
	
	
	@GetMapping("/new")
	public String sendManavForm(@ModelAttribute("manav") Manav manav) {
		return "manavForm"; 
	}
	
	
	@PostMapping("/saveManav")
	public String createManav(@Valid @ModelAttribute Manav manav, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "manavForm";
		}
		manavService.saveManav(manav);
		return "redirect:/manav";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") Integer id, Model model) {
		Manav manav= manavService.findManavById(id);
	    model.addAttribute("manav",manav);
	    return "manavForm";
	
	}
	
	@GetMapping("/delete")
	public String deleteManav(@RequestParam("id") Integer id) {
		manavService.deleteManav(id);
		return "redirect:/manav";
	}
	
	
	@GetMapping
	public ModelAndView getManav() {
		List<Manav> list= manavService.getAllManav();
		ModelAndView mav=new ModelAndView();
		mav.addObject("manav",list);
		mav.setViewName("manavs");
		return mav;
	}
	
}
