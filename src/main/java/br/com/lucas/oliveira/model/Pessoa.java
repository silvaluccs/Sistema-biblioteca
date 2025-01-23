package br.com.lucas.oliveira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pessoa {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(nullable = false)
	private String nome;
	
	@JoinColumn(nullable = false)
	private Integer idade;
	
	@JoinColumn(nullable = false)
	private String cpf;
	
	@JoinColumn(nullable = false)
	@OneToOne
	private ContaBiblioteca contaBiblioteca;
	
	
}
