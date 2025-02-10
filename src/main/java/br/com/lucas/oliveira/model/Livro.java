package br.com.lucas.oliveira.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Livro {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(nullable = false)
  private String nomeAutor;

  @JoinColumn(nullable = false)
  private String titulo;

  @JoinColumn(nullable = false)
  private int anoPublicacao;

  @JoinColumn(nullable = false)
  private String ISNB;

  @JoinColumn(nullable = false)
  private int numeroPaginas;

  @JoinColumn(nullable = false)
  private int quantidadeDeEmprestimos;
}
