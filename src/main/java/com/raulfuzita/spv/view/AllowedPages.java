package com.raulfuzita.spv.view;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllowedPages {

	@RequestMapping(value = {"/", "index"})
	@GetMapping
	String home(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			String username = authentication.getName();
			model.addAttribute("username", username);
		}
  		return "index";
	}
	
	@RequestMapping("about")
	@GetMapping
	String about(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			String username = authentication.getName();
			model.addAttribute("username", username);
		}
  		return "about";
	}
	
	@RequestMapping("register")
	@GetMapping
	String signup(Model model) {
  		return "register";
	}
}
