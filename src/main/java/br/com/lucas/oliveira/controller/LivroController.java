package br.com.lucas.oliveira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import br.com.lucas.oliveira.dto.LivroDTO;
import br.com.lucas.oliveira.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

  @Autowired
  private LivroService livroService;

  /*
   * Método para listar os livros de um determinado autor
   * 
   * @param NomeAutor - Nome do autor
   * 
   * @return - Lista de livros do autor
   */
  @GetMapping("/{nomeAutor}")
  public ResponseEntity<List<LivroDTO>> listarPorAutor(@PathVariable String nomeAutor) {

    List<LivroDTO> livros = livroService.listarPorAutor(nomeAutor);

    return ResponseEntity.ok(livros);

  }

  /*
   * Método para listar os livros de um determinado ano de publicação
   * 
   * @param anoPublicacao - Ano de publicação
   * 
   * @return - Lista de livros do ano de publicação
   */
  @GetMapping("/{anoPublicacao}")
  public ResponseEntity<List<LivroDTO>> listarPorAnoPublicacao(@PathVariable int anoPublicacao) {

    List<LivroDTO> livros = livroService.listarPorAnoPublicacao(anoPublicacao);

    return ResponseEntity.ok(livros);

  }

  /*
   * Método para listar os livros mais emprestados
   * 
   * @return - Lista de livros mais emprestados
   */
  @GetMapping("/maisEmprestados")
  public ResponseEntity<List<LivroDTO>> listarLivrosMaisEmprestados() {

    List<LivroDTO> livros = livroService.listarLivrosMaisEmprestados();

    return ResponseEntity.ok(livros);

  }
}
