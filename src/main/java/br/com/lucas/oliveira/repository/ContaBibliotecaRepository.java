package br.com.lucas.oliveira.repository;

import br.com.lucas.oliveira.model.ContaBiblioteca;

public interface ContaBibliotecaRepository {
	
	ContaBiblioteca buscar(Long id);
	ContaBiblioteca salvar(ContaBiblioteca contaBiblioteca);
	void remover(ContaBiblioteca contaBiblioteca);

}
