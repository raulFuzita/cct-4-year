package com.raulfuzita.spv.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllowedPages {

	@RequestMapping("/")
	@GetMapping
	String home(Model model) {
  		return "index";
	}
	
	@RequestMapping("index")
	@GetMapping
	String index(Model model) {
  		return "index";
	}
	
	@RequestMapping("about")
	@GetMapping
	String about(Model model) {
  		return "about";
	}
	
	@RequestMapping("register")
	@GetMapping
	String signup(Model model) {
  		return "register";
	}
}
