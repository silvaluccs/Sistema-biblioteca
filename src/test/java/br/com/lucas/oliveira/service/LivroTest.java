package br.com.lucas.oliveira.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import br.com.lucas.oliveira.model.Livro;

public class LivroTest {

  @Test
  public void equalsTest() {

    Livro livro1 = new Livro();
    Livro livro2 = new Livro();

    livro1.setId(2);
    livro2.setId(2);

    assertEquals(livro1.getId(), livro2.getId());

  }

}
