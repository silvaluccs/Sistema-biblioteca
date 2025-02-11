package br.com.lucas.oliveira.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import br.com.lucas.oliveira.model.utils.ArvoreAvl;
import br.com.lucas.oliveira.repository.LivroRepository;
import jakarta.annotation.PostConstruct;
import br.com.lucas.oliveira.exception.EntidadeExistenteException;
import br.com.lucas.oliveira.exception.EntidadeNaoEncontradaException;
import br.com.lucas.oliveira.model.Livro;
import br.com.lucas.oliveira.dto.LivroDTO;

@Service
public class LivroService {

  private ArvoreAvl arvoreAvl;

  @Autowired
  private LivroRepository livroRepository;

  /*
   * Método para carregar a árvore de livros
   */
  @PostConstruct
  private void carregarArvore() {
    arvoreAvl = new ArvoreAvl();
    livroRepository.listar().forEach(livro -> arvoreAvl.inserirLivro(livro));
  }

  /*
   * Método para salvar um livro
   */
  public LivroDTO salvar(Livro livro) throws EntidadeExistenteException {

    try {
      arvoreAvl.inserirLivro(livro);

      livro = livroRepository.salvar(livro);

      return LivroDTO.toDTO(livro);

    } catch (IllegalArgumentException e) {
      throw new EntidadeExistenteException(e.getMessage());
    }

  }

  /*
   * Método para buscar um livro
   */
  public LivroDTO buscar(Long id) throws EntidadeNaoEncontradaException {

    Livro livro = arvoreAvl.pesquisarLivro(id);

    if (livro == null) {
      throw new EntidadeNaoEncontradaException(
          String.format("Erro: O livro %s não foi encontrado no banco de dados.", id));
    }

    return LivroDTO.toDTO(livro);

  }

  public List<LivroDTO> listarPorAutor(String autor) {

    return arvoreAvl.toList().stream()
        .filter(livro -> livro.getNomeAutor().equalsIgnoreCase(autor)).map(LivroDTO::toDTO)
        .toList();

  }

  public List<LivroDTO> listarPorAnoPublicacao(int anoPublicacao) {

    return arvoreAvl.toList().stream()
        .filter(livro -> livro.getAnoPublicacao() == anoPublicacao).map(LivroDTO::toDTO)
        .toList();

  }

  public List<LivroDTO> listarLivrosMaisEmprestados() {

    return arvoreAvl.toList().stream()
        .sorted((livro1, livro2) -> Integer.compare(livro2.getQuantidadeDeEmprestimos(),
            livro1.getQuantidadeDeEmprestimos()))
        .map(LivroDTO::toDTO).toList();

  }

}
