package br.com.java.dao;

import java.util.List;

import br.com.java.model.Aluno;

public interface Dao {
	
	void inserir(Aluno aluno);

	void atualizar(Aluno aluno);

	void remover(Aluno aluno);

	Aluno pesquizarId(int Id);

	List<Aluno> todos();

}
