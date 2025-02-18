package br.com.lucas.oliveira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.oliveira.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
