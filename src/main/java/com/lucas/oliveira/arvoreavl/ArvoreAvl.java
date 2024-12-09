package com.lucas.oliveira.arvoreavl;

import com.lucas.oliveira.arvoreavl.Node;
import com.lucas.oliveira.livro.Livro;

// classe responsável pela árvore avl que gerencia os livros
public class ArvoreAvl {

  Node root;

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
    if (is_empty(N)) {
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
    if (is_empty(N)) {
      return 0;
    }

    return altura(N.esquerda) - altura(N.direita);

  }

  private boolean is_empty(Node raiz) {
    return raiz == null;
  }

  // função para rotacionar a árvore
  private Node rotacionarArvore(Node raiz, Livro livro) {

    if (is_empty(raiz)) {
      return raiz;
    }

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

  // função recursiva para inserir na árvore;
  public Node inserir(Livro livro, Node raiz) throws IllegalArgumentException {

    if (is_empty(raiz)) {
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

    return rotacionarArvore(raiz, livro);

  }

  // função recursiva para remover um livro da árvore com base no id
  // função remove por atualização de ponteiros

  public Node remover(Livro livro, Node raiz) throws IllegalArgumentException {

    if (is_empty(raiz)) {
      throw new IllegalArgumentException("Erro: Não é possível remover, pois o banco de dados está vazio.");
    }

    Node guardarRaiz = raiz;

    // buscando o id do livro na árvore
    if (livro.getId() < raiz.livro.getId()) {
      raiz.esquerda = remover(livro, raiz.esquerda);
    } else if (livro.getId() > raiz.livro.getId()) {
      raiz.direita = remover(livro, raiz.direita);
    } else {

      // neste caso o id foi encontrado

      if (raiz.direita == null || raiz.esquerda == null) { // caso o nó a ser removido tenha um filho ou nenhum

        guardarRaiz = raiz.esquerda != null ? raiz.esquerda : raiz.direita;
        System.gc(); // chamando o coletor de lixo

      } else { // caso o nó a ser removido tenha dois filhos

        Node anteriorGuardarRaiz = null;
        guardarRaiz = raiz.direita;

        while (guardarRaiz.esquerda != null) { // percorrendo o nó mais esquerda do filho da direita do nó a ser
                                               // removido
          anteriorGuardarRaiz = guardarRaiz;
          guardarRaiz = guardarRaiz.esquerda;
        }

        guardarRaiz.esquerda = raiz.esquerda; // atualizando os ponteirps

        if (anteriorGuardarRaiz != null) {
          anteriorGuardarRaiz.esquerda = guardarRaiz.direita;
          guardarRaiz.direita = raiz.direita;
        }

        System.gc(); // chamando o coletor de lixo

      }

    }
    if (is_empty(guardarRaiz)) {
      return guardarRaiz;
    }
    guardarRaiz.altura = Math.max(altura(guardarRaiz.direita), altura(guardarRaiz.esquerda)) + 1;
    return rotacionarArvore(guardarRaiz, livro);
  }

  public boolean pesquisar(Livro livro, Node raiz) {
    if (is_empty(raiz)) { // caso base, livro não encontrado
      return false;
    }

    if (livro.getId() < raiz.livro.getId()) {
      return pesquisar(livro, raiz.esquerda); // procurando nos ramos da esquerda
    } else if (livro.getId() > raiz.livro.getId()) {
      return pesquisar(livro, raiz.direita); // procurando nos ramos da direita
    } else {
      return true; // caso tenha achado o livro na coleção
    }

  }

  // função recursiva para atualizar um livro

  public Node atualizar(Livro novoLivro, Node raiz) {

    if (is_empty(raiz)) {
      throw new IllegalArgumentException(String.format(
          "Erro: Não foi possivél atualizar o livro %s, porque o banco de dados está vazio.", novoLivro.getTitulo()));
    }

    if (novoLivro.getId() < raiz.livro.getId()) { // procurando no ramo da esquerda
      raiz.esquerda = atualizar(novoLivro, raiz.esquerda);

    } else if (novoLivro.getId() > raiz.livro.getId()) { // procurando no ramo da direita
      raiz.direita = atualizar(novoLivro, raiz.direita);

    } else {
      if (raiz.livro.equals(novoLivro)) {
        raiz.livro = novoLivro;
      } else {
        throw new IllegalArgumentException(String.format(
            "Erro: Não foi possível atualizar pois, o livro %s é diferente do que consta no banco de dados.",
            novoLivro.getTitulo()));
      }
    }

    return raiz;

  }

  public void preOrder(Node raiz) {

    if (raiz != null) {

      System.out.println(raiz.livro.getTitulo());
      preOrder(raiz.esquerda);
      preOrder(raiz.direita);

    }

  }

  public static void main(String[] args) {

    // TODO: Realizar os casos de teste para as funções
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
