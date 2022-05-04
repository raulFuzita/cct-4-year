package com.raulfuzita.spv.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	@RequestMapping("/")
	@GetMapping
	String home(Model model) {
		model.addAttribute("brand", "SPV");
  		return "index";
	}
}
