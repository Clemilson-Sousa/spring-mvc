package com.webapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.model.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@GetMapping("/formAluno")
	public String login() {
		return "aluno/formAluno";
	}

	@PostMapping("/validateAluno")
	public String validateAluno(Aluno aluno, Model model) {
		System.out.println("Aluno recebido com sucesso: " + aluno);
		model.addAttribute("mensagem", "Aluno cadastrado com sucesso!");
		return "aluno/formAluno";
	}
	
	@ModelAttribute("paises")
	public List<String> getPaises() {
		return Arrays.asList(new String[] {"Canada", "Estados Unidos", "Brasil", "França", "Reino Unido"});
	}
	
	@ModelAttribute("linguagens")
	public List<String> getLinguagens() {
		return Arrays.asList(new String[] {"Java", "Python", "Java Script", "Ruby", "PHP"});
	}
	
	@ModelAttribute("linguas")
	public List<String> getLinguas() {
		return Arrays.asList(new String[] {"Canadense", "Inglês", "Português", "Frances", "Alemão"});
	}
	
}
