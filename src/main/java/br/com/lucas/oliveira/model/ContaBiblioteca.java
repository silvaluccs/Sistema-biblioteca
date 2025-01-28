package br.com.lucas.oliveira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ContaBiblioteca { 

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(nullable = false)
	private String login;
	
	@JoinColumn(nullable = false)
	private String senha;
	
	@JoinColumn(nullable = false)
	private Float saldo;
	
	@JoinColumn(nullable = false)
	private Boolean logado;
	
}