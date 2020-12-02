package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/form-login")
	public String home() {
		return "formLogin";
	}
	
	@PostMapping("/processaLogin")
	public String processaLogin(String dados) {
		return dados;
	}
}
