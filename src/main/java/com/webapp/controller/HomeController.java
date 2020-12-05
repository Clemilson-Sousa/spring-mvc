package com.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("home")
	public String home() {
		return "home";
	}
	
	@GetMapping("login")
	public String login() {
		return "formLogin";
	}
	
	@PostMapping("processaLogin")
	public String processaLogin(HttpServletRequest request, Model model) {
		String view = "formLogin";
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		if (login.contentEquals("Clemilson") && senha.contentEquals("123")) {
			model.addAttribute("usuario", login);
			model.addAttribute("senha", senha);
			view = "login-in";
		}
		return view;
	}
}
