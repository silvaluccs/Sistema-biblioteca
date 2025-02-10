package br.com.lucas.oliveira.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import br.com.lucas.oliveira.model.utils.ArvoreAvl;
import br.com.lucas.oliveira.repository.LivroRepository;
import br.com.lucas.oliveira.exception.EntidadeExistenteException;
import br.com.lucas.oliveira.exception.EntidadeNaoEncontradaException;
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

  /*
   * Método para salvar um livro
   */
  public Livro salvar(Livro livro) throws EntidadeExistenteException {

    try {
      arvoreAvl.inserirLivro(livro);
      return livroRepository.salvar(livro);
    } catch (IllegalArgumentException e) {
      throw new EntidadeExistenteException(e.getMessage());
    }

  }

  /*
   * Método para buscar um livro
   */
  public Livro buscar(Long id) throws EntidadeNaoEncontradaException {

    Livro livro = arvoreAvl.pesquisarLivro(id);

    if (livro == null) {
      throw new EntidadeNaoEncontradaException(
          String.format("Erro: O livro %s não foi encontrado no banco de dados.", id));
    }

    return livro;

  }

  public List<Livro> listarPorAutor(String autor) {

    return arvoreAvl.toList().stream()
        .filter(livro -> livro.getNomeAutor().equalsIgnoreCase(autor)).toList();

  }

  public List<Livro> listarPorAnoPublicacao(int anoPublicacao) {

    return arvoreAvl.toList().stream()
        .filter(livro -> livro.getAnoPublicacao() == anoPublicacao).toList();

  }

  public List<Livro> listarLivrosMaisEmprestados() {

    return arvoreAvl.toList().stream()
        .sorted((livro1, livro2) -> Integer.compare(livro2.getQuantidadeDeEmprestimos(),
            livro1.getQuantidadeDeEmprestimos()))
        .toList();

  }

}
