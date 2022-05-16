package com.raulfuzita.spv.view;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.raulfuzita.spv.prediction.Property;

@CrossOrigin(origins="http://localhost:8080")
@Controller
public class Prediction {

	@GetMapping("prediction")
	public String prediction(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		model.addAttribute("username", username);
		return "prediction";
	}
}
