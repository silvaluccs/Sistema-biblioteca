package br.com.lucas.oliveira.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.oliveira.model.utils.ArvoreAvl;
import br.com.lucas.oliveira.repository.LivroRepository;
import br.com.lucas.oliveira.exception.EntidadeExistenteException;
import br.com.lucas.oliveira.model.Livro;

@Service
public class LivroService {

  private ArvoreAvl arvoreAvl;

  @Autowired
  private LivroRepository livroRepository;

  public LivroService() {
    carregarArvore();
  }

  /*
   * Método para carregar a árvore de livros
   */
  private void carregarArvore() {
    arvoreAvl = new ArvoreAvl();
    livroRepository.listar().forEach(livro -> arvoreAvl.inserirLivro(livro));
  }

  public Livro salvar(Livro livro) throws EntidadeExistenteException {

    try {
      arvoreAvl.inserirLivro(livro);
      return livroRepository.salvar(livro);
    } catch (IllegalArgumentException e) {
      throw new EntidadeExistenteException(e.getMessage());
    }

  }

  public Livro buscar(Long id) {

  }

}
