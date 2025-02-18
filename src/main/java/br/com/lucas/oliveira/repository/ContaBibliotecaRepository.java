package br.com.lucas.oliveira.repository;

import br.com.lucas.oliveira.model.ContaBiblioteca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaBibliotecaRepository extends JpaRepository<ContaBiblioteca, Long> {

}
