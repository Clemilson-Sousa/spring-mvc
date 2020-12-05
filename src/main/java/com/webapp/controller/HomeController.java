package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@PostMapping("processaLogin")
	public String loginValidate(@RequestParam("login") String login, @RequestParam("senha") String senha, Model model) {
		String view = "formLogin";
		if (login.contentEquals("Clemilson") && senha.contentEquals("123")) {
			model.addAttribute("usuario", login);
			model.addAttribute("senha", senha);
			view = "login-in";
		}
		return view;
	}
}
