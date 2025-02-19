package br.com.lucas.oliveira.util;

class Node<T> {
  public Node<T> esquerda, direita;
  Integer altura;
  T tipo;

  Node(T tipo) {
    this.tipo = tipo;
    this.altura = 1;
    this.esquerda = this.direita = null;
  }

  Node() {
    this(null);
  }
}
