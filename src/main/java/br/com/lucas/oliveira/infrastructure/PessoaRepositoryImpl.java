package br.com.lucas.oliveira.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.lucas.oliveira.model.Pessoa;
import br.com.lucas.oliveira.repository.PessoaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/*
 * Classe de implementação do repositório de pessoa
 */

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	/*
	 * Método para listar uma pessoa do banco de dados
	 */
	@Override
	public List<Pessoa> listar() {
		return manager.createQuery("from Pessoa", Pessoa.class).getResultList();
	}

	/*
	 * Método para buscar uma pessoa do banco de dados
	 */
	@Override
	public Pessoa buscar(Long id) {
		return manager.find(Pessoa.class, id);
	}

	/*
	 * Método para salvar uma pessoa do banco de dados
	 */
	@Transactional
	@Override
	public Pessoa salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}

	/*
	 * Método para atualizar uma pessoa do banco de dados
	 */
	@Transactional
	@Override
	public Pessoa atualizar(Pessoa pessoa) {
		
		Pessoa pessoaParaAtualizar = buscar(pessoa.getId());
		
		if (pessoaParaAtualizar != null) {
			return salvar(pessoa);
		}
		return null;
	}

	/*
	 * Método para remover uma pessoa do banco de dados
	 */
	@Transactional
	@Override
	public void remover(Pessoa pessoa) {
		
		Pessoa pessoaParaRemover = buscar(pessoa.getId());
		if (pessoaParaRemover != null) {
			manager.remove(pessoaParaRemover);
		}
		
	}

}
