package com.lucas.oliveira.arvoreavl;

import com.lucas.oliveira.livro.Livro;

public class Node {
  public Node esquerda, direita;
  Integer altura;
  Livro livro;

  public Node(Livro livro) {
    this.livro = livro;
    this.altura = 0;
    this.esquerda = this.direita = null;

  }

  public Node() {
    this(0);
  }

}
