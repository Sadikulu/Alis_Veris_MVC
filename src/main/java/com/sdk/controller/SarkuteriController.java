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

import com.sdk.domain.Sarkuteri;
import com.sdk.service.SarkuteriService;


@Controller  
@RequestMapping("/sarkuteri")
public class SarkuteriController {
	
	@Autowired
	private SarkuteriService sarkuteriService;
	

	@GetMapping("/hello")
	public ModelAndView sayHi() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Hi");
		mav.addObject("messagebody","Welcome to SADIK BAKKAL");
		mav.setViewName("hi");
		return mav;
	}
	
	@GetMapping("/new")
	public String sendSarkuteriForm(@ModelAttribute("sarkuteri") Sarkuteri sarkuteri) {
		return "sarkuteriForm"; 
	}
	
	@PostMapping("/saveSarkuteri")
	public String createSarkuteri(@Valid @ModelAttribute Sarkuteri sarkuteri, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "sarkuteriForm";
		}
		sarkuteriService.saveSarkuteri(sarkuteri);
		return "redirect:/sarkuteri";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") Integer id, Model model) {
		Sarkuteri sarkuteri= sarkuteriService.findSarkuteriById(id);
	    model.addAttribute("sarkuteri",sarkuteri);
	    return "sarkuteriForm";
	
	}
	
	@GetMapping("/delete")
	public String deleteSarkuteri(@RequestParam("id") Integer id) {
		sarkuteriService.deleteSarkuteri(id);
		return "redirect:/sarkuteri";
	}
	
	@GetMapping
	public ModelAndView getSarkuteri() {
		List<Sarkuteri> list= sarkuteriService.getAllSarkuteri();
		ModelAndView mav=new ModelAndView();
		mav.addObject("sarkuteri",list);
		mav.setViewName("sarkuteri");
		return mav;
	}
}
