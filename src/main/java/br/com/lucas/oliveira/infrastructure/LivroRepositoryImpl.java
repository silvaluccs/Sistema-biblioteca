package br.com.lucas.oliveira.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucas.oliveira.model.Livro;
import br.com.lucas.oliveira.repository.LivroRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LivroRepositoryImpl implements LivroRepository {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public List<Livro> listar() {
    return manager.createQuery("from Livro", Livro.class).getResultList();
  }

  @Transactional
  @Override
  public Livro salvar(Livro livro) {
    return manager.merge(livro);
  }

  @Override
  public Livro buscar(Long id) {
    return manager.find(Livro.class, id);
  }

  @Transactional
  @Override
  public void remover(Long id) {
    Livro livro = buscar(id);
    if (livro != null) {
      manager.remove(livro);
    }
  }

}
