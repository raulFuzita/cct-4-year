package com.raulfuzita.spv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class SpvApplication {

	/*
	 * @RequestMapping("/")
	 * @ResponseBody String home() { return "Hello World!"; }
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(SpvApplication.class, args);
	}

}
