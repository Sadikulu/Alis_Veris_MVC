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

import com.sdk.domain.Yonetici;
import com.sdk.service.YoneticiService;

@Controller  
@RequestMapping("/yonetici")
public class YoneticiController {

	@Autowired
	private YoneticiService yoneticiService;
	
	@GetMapping("/new")
	public String sendYoneticiForm(@ModelAttribute("yonetici") Yonetici yonetici) {
		return "yoneticiKayitForm"; 
	}
	
	@PostMapping("/saveYonetici")
	public String createYonetici(@Valid @ModelAttribute Yonetici yonetici,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "yoneticiKayitForm";
		}
			yoneticiService.saveYonetici(yonetici);
		    return "redirect:/yonetici";
	}
	
	@GetMapping
	public ModelAndView getYonetici() {
		List<Yonetici> list= yoneticiService.getAllYonetici();
		ModelAndView mav=new ModelAndView();
		mav.addObject("yonetici",list);
		mav.setViewName("yoneticiList");
		return mav;
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") Integer id, Model model) {
		Yonetici yonetici= yoneticiService.findYoneticiById(id);
	    model.addAttribute("yonetici",yonetici);
	    return "yoneticiKayitForm";
	
	}
	
	@GetMapping("/delete")
	public String deleteSarkuteri(@RequestParam("id") Integer id) {
		yoneticiService.deleteYonetici(id);
		return "redirect:/yonetici";
	}
	
	@GetMapping("/list")
	public ModelAndView getAllYonetici() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("yonetici");
		return mav;
	}
	
	@GetMapping("/enter")
	public String enterYoneticiForm(@ModelAttribute("yonetici") Yonetici yonetici) {
		return "yoneticiForm"; 
	}
	
	@PostMapping("/enterYonetici")
	public String enterYonetici(@ModelAttribute Yonetici yonetici, String username, String password) {
		List<String> listUsername= yoneticiService.getYoneticiUserName();
		List<String> listPassword= yoneticiService.getYoneticiPassword();
		
		if(listUsername.contains(username) && listPassword.contains(password)) {
			return "redirect:/yonetici/list";
		}
		else {
			return "yoneticiForm";
		}
	
	}
}
