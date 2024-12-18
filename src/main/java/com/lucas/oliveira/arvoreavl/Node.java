package com.lucas.oliveira.arvoreavl;

import com.lucas.oliveira.livro.Livro;

class Node {
  public Node esquerda, direita;
  Integer altura;
  Livro livro;

  Node(Livro livro) {
    this.livro = livro;
    this.altura = 1;
    this.esquerda = this.direita = null;
  }

  Node() { this(null); }
}
