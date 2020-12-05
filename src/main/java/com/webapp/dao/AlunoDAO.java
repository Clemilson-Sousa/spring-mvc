package com.webapp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.webapp.model.Aluno;

@Repository
public class AlunoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Set<Aluno> alunos = new HashSet<Aluno>();

	public Aluno findById(Integer id) {
		for (Aluno aluno : alunos) {
			if (aluno.getId().equals(id)) {
				return aluno;
			}
		}
		return null;
	}

	public Aluno find(Aluno aluno) {
		for (Aluno a : alunos) {
			if (a.equals(aluno)) {
				return a;
			}
		}
		return null;
	}

	public boolean delete(Aluno aluno) {
		return alunos.remove(aluno);
	}

	public Aluno update(Aluno aluno) {
		Aluno a = this.findById(aluno.getId());
		if (a != null) {
			alunos.remove(a);
			alunos.add(aluno);
			return aluno;
		}
		return a;
	}

	public Integer insert(Aluno aluno) {
		Integer maxId = this.findMaxId();
		aluno.setId(++maxId);
		alunos.add(aluno);
		return maxId;
	}

	private Integer findMaxId() {
		Optional<Aluno> a = alunos.stream().max(Comparator.comparing(Aluno::getId));
		if (a.isPresent()) {
			return a.get().getId();
		} else {
			return 0;
		}
	}
	
	public List<Aluno> findAll() {
		return new ArrayList<Aluno>(alunos);
	}

}
