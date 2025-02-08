package br.com.lucas.oliveira.repository;

import java.util.List;
import br.com.lucas.oliveira.model.Livro;

public interface LivroRepository {

  List<Livro> listar();

  Livro salvar(Livro livro);

  Livro buscar(Long id);

  void remover(Long id);

}
