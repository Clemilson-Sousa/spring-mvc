package com.webapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.dao.AlunoDAO;
import com.webapp.model.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoDAO alunoDao;

	@GetMapping("/formAluno")
	public String login(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "aluno/formAluno";
	}

	@PostMapping("/cadastro")
	public String cadastrar(Aluno aluno, Model model) {
		if(aluno.getId() == null) {
			alunoDao.insert(aluno);
		} else {
			alunoDao.update(aluno);
		}
		model.addAttribute("mensagem", "Aluno cadastrado com sucesso! ID: " + aluno.getId());
		model.addAttribute("aluno", new Aluno());
		return "aluno/formAluno";
	}
	
	@GetMapping("/{id}")
	public String update(@PathVariable Integer id, Model model) {
		Aluno aluno = alunoDao.findById(id);
		model.addAttribute("aluno", aluno);
		return "aluno/formAluno";
	}

	@ModelAttribute("paises")
	public List<String> getPaises() {
		return Arrays.asList(new String[] { "Canada", "Estados Unidos", "Brasil", "França", "Reino Unido" });
	}

	@ModelAttribute("linguagens")
	public List<String> getLinguagens() {
		return Arrays.asList(new String[] { "Java", "Python", "Java Script", "Ruby", "PHP" });
	}

	@ModelAttribute("linguas")
	public List<String> getLinguas() {
		return Arrays.asList(new String[] { "Canadense", "Inglês", "Português", "Frances", "Alemão" });
	}

}
