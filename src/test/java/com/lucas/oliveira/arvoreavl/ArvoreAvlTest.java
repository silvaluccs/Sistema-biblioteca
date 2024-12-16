package com.lucas.oliveira.arvoreavl;

import com.lucas.oliveira.arvoreavl.ArvoreAvl;
import com.lucas.oliveira.livro.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArvoreAvlTest {

  private ArvoreAvl raiz;
  Livro livro1;
  Livro livro2;
  Livro livro3;
  Livro livro4;
  Livro livro5;

  @BeforeEach
  public void instanciaLivros() {

    raiz = new ArvoreAvl();
    livro1 = new Livro("George Orwell", "1984", 1949, "978-0451524935", 328,
                       1200, 1);
    livro2 = new Livro("J.K. Rowling", "Harry Potter e a Pedra Filosofal", 1997,
                       "978-0747532699", 223, 1500, 2);
    livro3 = new Livro("F. Scott Fitzgerald", "O Grande Gatsby", 1925,
                       "978-0743273565", 180, 850, 3);
    livro4 = new Livro("Harper Lee", "O Sol é para Todos", 1960,
                       "978-0061120084", 324, 1100, 4);
    livro5 =
        new Livro("J.R.R. Tolkien", "O Senhor dos Anéis: A Sociedade do Anel",
                  1954, "978-0618640157", 423, 1300, 5);

    raiz.inserirLivro(livro5);
    raiz.inserirLivro(livro4);
    raiz.inserirLivro(livro3);
    raiz.inserirLivro(livro2);
    raiz.inserirLivro(livro1);
  }

  @Test
  public void pesquisarLivroExistenteNaArvoreTest() {
    boolean livroNoAcervo = raiz.pesquisarLivro(livro5);
    Assertions.assertTrue(livroNoAcervo);
  }

  @Test
  public void pesquisarLivroNaoExistenteNaArvoreTest() {
    raiz.removerLivro(livro4);
    boolean livroNoAcervo = raiz.pesquisarLivro(livro4);
    Assertions.assertFalse(livroNoAcervo);
  }

  @Test
  public void removerLivroDoArvoreTest() {

    raiz.removerLivro(livro4);
    boolean livroNoAcervo = raiz.pesquisarLivro(livro4);
    Assertions.assertFalse(livroNoAcervo);
  }

  @Test
  public void removerLivroDaArvoreVaziaTest() {

    ArvoreAvl arvoreVazia = new ArvoreAvl();

    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> arvoreVazia.removerLivro(livro1));
  }

  @Test
  public void inserirLivroExistenteNaAvoreTest() {

    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> raiz.inserirLivro(livro4));
  }

  @Test
  public void atualizarLivroNaArvoreVazia() {
    ArvoreAvl arvoreVazia = new ArvoreAvl();

    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> arvoreVazia.atualizarLivro(livro2));
  }
}
