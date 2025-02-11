package br.com.lucas.oliveira.dto;

import br.com.lucas.oliveira.model.Livro;
import lombok.Data;

@Data
public class LivroDTO {

  private String titulo;
  private String autor;
  private int anoPublicacao;
  private int numeroPaginas;
  private int isbn;

  public static LivroDTO toDTO(Livro livro) throws IllegalArgumentException {

    if (livro == null) {
      throw new IllegalArgumentException("Livro não pode ser nulo");
    }

    LivroDTO livroDTO = new LivroDTO();

    livroDTO.setTitulo(livro.getTitulo());
    livroDTO.setAutor(livro.getNomeAutor());
    livroDTO.setAnoPublicacao(livro.getAnoPublicacao());
    livroDTO.setNumeroPaginas(livro.getNumeroPaginas());

    return livroDTO;
  }

}
