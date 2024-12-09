package com.lucas.oliveira.arvoreavl;

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

  public void inserirLivro(Livro livro) throws IllegalArgumentException {
    this.root = inserir(livro, this.root);
  }

  // função recursiva para inserir na árvore;
  private Node inserir(Livro livro, Node raiz) throws IllegalArgumentException {

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

  public void removerLivro(Livro livro) throws  IllegalArgumentException {
    this.root = remover(livro, this.root);
  }

  private Node remover(Livro livro, Node raiz) throws IllegalArgumentException {

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


  public boolean pesquisarLivro(Livro livro) {
    return pesquisar(livro, this.root);
  }

  private boolean pesquisar(Livro livro, Node raiz) {
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

  public void atualizarLivro  (Livro novoLivro) throws IllegalArgumentException {
    this.root = atualizar(novoLivro, this.root);
  }

  private Node atualizar(Livro novoLivro, Node raiz) throws IllegalArgumentException {

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


}
