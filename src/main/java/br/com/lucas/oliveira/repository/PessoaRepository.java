package br.com.lucas.oliveira.repository;

import java.util.List;

import br.com.lucas.oliveira.model.Pessoa;

public interface PessoaRepository {
	
	List<Pessoa> listar();
	Pessoa buscar(Long id);
	Pessoa salvar(Pessoa pessoa);
	void remover(Pessoa pessoa);

}
