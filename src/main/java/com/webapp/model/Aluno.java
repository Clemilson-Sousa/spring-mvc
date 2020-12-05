package com.webapp.model;

import java.util.List;

public class Aluno {
	
	private String nome;
	private Long matricula;
	private String login;
	private String pais;
	private String linguagem;
	private List<String> fluencia;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	public List<String> getFluencia() {
		return fluencia;
	}
	public void setFluencia(List<String> fluencia) {
		this.fluencia = fluencia;
	}
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", login=" + login + ", pais=" + pais
				+ ", linguagem=" + linguagem + ", fluencia=" + fluencia + "]";
	}

}
