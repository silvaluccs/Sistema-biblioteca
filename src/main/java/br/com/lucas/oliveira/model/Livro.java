package br.com.lucas.oliveira.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
  private int anoPublicao;

  @JoinColumn(nullable = false)
  private String ISNB;

  @JoinColumn(nullable = false)
  private int numeroPaginas;
}
