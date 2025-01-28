package br.com.lucas.oliveira.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.lucas.oliveira.model.ContaBiblioteca;
import br.com.lucas.oliveira.repository.ContaBibliotecaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ContaBibliotecaRepositoryImpl implements ContaBibliotecaRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public ContaBiblioteca buscar(Long id) {
		return manager.find(ContaBiblioteca.class, id);
	}

	@Transactional
	@Override
	public ContaBiblioteca salvar(ContaBiblioteca contaBiblioteca) {
		return manager.merge(contaBiblioteca);
	}


	@Transactional
	@Override
	public void remover(ContaBiblioteca contaBiblioteca) {
		ContaBiblioteca contaParaRemover = buscar(contaBiblioteca.getId());
		if (contaParaRemover != null) {
			manager.remove(contaBiblioteca);
		}
		
	}
	
	

}
