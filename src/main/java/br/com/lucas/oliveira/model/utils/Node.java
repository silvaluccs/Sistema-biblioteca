package br.com.lucas.oliveira.model.utils;

import br.com.lucas.oliveira.model.Livro;

class Node {
  public Node esquerda, direita;
  Integer altura;
  Livro livro;

  Node(Livro livro) {
    this.livro = livro;
    this.altura = 1;
    this.esquerda = this.direita = null;
  }

  Node() {
    this(null);
  }
}
