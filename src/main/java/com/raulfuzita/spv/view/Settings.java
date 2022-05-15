package com.raulfuzita.spv.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins="http://127.0.0.1:8080")
@Controller
public class Settings {

	@GetMapping("settings")
	public String login(Model model) {
		return "settings";
	}
}
