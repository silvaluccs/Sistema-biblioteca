package com.lucas.oliveira.arvoreavl;

import com.lucas.oliveira.arvoreavl.Node;
import com.lucas.oliveira.livro.Livro;

// classe responsável pela árvore avl que gerencia os livros
public class ArvoreAvl {

  private Node root;

  public ArvoreAvl() {
    this.root = null;
  }

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  // função para obter a altura de um nó
  private int altura(Node N) {
    if (N == null) {
      return 0;
    }

    return N.altura;

  }

  // função responsável por rotacinar a árvore para direita
  private Node rotacaoDireita(Node pai) {

    Node filhoEsquerdo = pai.esquerda;
    pai.esquerda = filhoEsquerdo.direita;
    filhoEsquerdo.direita = pai;

    // atualizando as alturas
    pai.altura = Math.max(altura(pai.direita), altura(pai.esquerda)) + 1;
    filhoEsquerdo.altura = Math.max(altura(filhoEsquerdo.esquerda), altura(filhoEsquerdo.direita)) + 1;

    return filhoEsquerdo;

  }

  // função responsável por rotacinar para a esquerda
  private Node rotacaoEsquerda(Node pai) {

    Node filhoDireita = pai.direita;
    pai.direita = filhoDireita.esquerda;
    filhoDireita.esquerda = pai;

    // atualizando as alturas
    pai.altura = Math.max(altura(pai.esquerda), altura(pai.direita)) + 1;
    filhoDireita.altura = Math.max(altura(filhoDireita.esquerda), altura(filhoDireita.direita)) + 1;

    return filhoDireita;

  }

  // função para obter o fator de balanceamento, considerando esquerda como
  // positivo
  private int fatorBalanceamento(Node N) {
    if (N == null) {
      return 0;
    }

    return altura(N.esquerda) - altura(N.direita);

  }

  // função recursiva para inserir na árvore;
  public Node inserir(Livro livro, Node raiz) throws IllegalArgumentException {

    if (raiz == null) {
      return new Node(livro);
    }

    if (livro.getId() < raiz.livro.getId()) { // inserindo no ramo esquerdo da árvore

      raiz.esquerda = inserir(livro, raiz.esquerda);

    } else if (livro.getId() > raiz.livro.getId()) {
      raiz.direita = inserir(livro, raiz.direita); // inserindo no ramo direito da árvore

    } else { // caso o livro já exista na coleção
      throw new IllegalArgumentException(
          String.format("Erro: O livro %s, do autor %s, já existe no acervo.\nAtualize a quantidade de exemplares",
              livro.getTitulo(), livro.getNomeAutor()));
    }

    raiz.altura = Math.max(altura(raiz.esquerda), altura(raiz.direita)) + 1; // atualizando a altura

    int fatorBalanco = fatorBalanceamento(raiz);

    if (fatorBalanco > 1) {

      if (livro.getId() < raiz.esquerda.livro.getId()) { // neste caso ocorre uma rotação LL

        return rotacaoDireita(raiz);

      } else {
        raiz.esquerda = rotacaoEsquerda(raiz.esquerda); // neste caso ocorre uma rotação LR;
        return rotacaoDireita(raiz);
      }

    }

    if (fatorBalanco < -1) {

      if (livro.getId() > raiz.direita.livro.getId()) { // neste caso ocorre uma rotação RR
        return rotacaoEsquerda(raiz);
      } else {
        raiz.direita = rotacaoDireita(raiz.direita); // neste caso ocorre uma rotação RL
        return rotacaoEsquerda(raiz);
      }

    }

    return raiz; // caso o node já esteja balanceado

  }

  public void preOrder(Node raiz) {

    if (raiz != null) {

      System.out.println(raiz.livro.getTitulo());
      preOrder(raiz.esquerda);
      preOrder(raiz.direita);

    }

  }

  public static void main(String[] args) {

    ArvoreAvl avv = new ArvoreAvl();

    Livro livro1 = new Livro("George Orwell", "1984", 1949, "978-0451524935", 328, 1200, 1);
    Livro livro2 = new Livro("J.K. Rowling", "Harry Potter e a Pedra Filosofal", 1997, "978-0747532699", 223, 1500, 2);
    Livro livro3 = new Livro("F. Scott Fitzgerald", "O Grande Gatsby", 1925, "978-0743273565", 180, 850, 3);
    Livro livro4 = new Livro("Harper Lee", "O Sol é para Todos", 1960, "978-0061120084", 324, 1100, 4);
    Livro livro5 = new Livro("J.R.R. Tolkien", "O Senhor dos Anéis: A Sociedade do Anel", 1954, "978-0618640157", 423,
        1300, 5);

    avv.setRoot(avv.inserir(livro5, avv.getRoot()));
    avv.setRoot(avv.inserir(livro4, avv.getRoot()));
    avv.setRoot(avv.inserir(livro3, avv.getRoot()));
    avv.setRoot(avv.inserir(livro2, avv.getRoot()));
    avv.setRoot(avv.inserir(livro1, avv.getRoot()));

    avv.preOrder(avv.getRoot());

  }

}
