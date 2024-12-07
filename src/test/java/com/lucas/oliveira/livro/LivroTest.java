package com.lucas.oliveira.livro;

import com.lucas.oliveira.livro.Livro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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
