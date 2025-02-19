package br.com.lucas.oliveira.util;

import java.util.ArrayList;
import java.util.List;

// classe responsável pela árvore avl que gerencia as entidades
public class ArvoreAvl<T extends ElementoAvl> {

  private Node<T> root;

  public ArvoreAvl() {
    this.root = null;
  }

  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }

  // função para obter a altura de um nó
  private int altura(Node<T> N) {
    if (is_empty(N)) {
      return 0;
    }

    return N.altura;

  }

  // função responsável por rotacinar a árvore para direita
  private Node<T> rotacaoDireita(Node<T> pai) {

    Node<T> filhoEsquerdo = pai.esquerda;
    pai.esquerda = filhoEsquerdo.direita;
    filhoEsquerdo.direita = pai;

    // atualizando as alturas
    pai.altura = Math.max(altura(pai.direita), altura(pai.esquerda)) + 1;
    filhoEsquerdo.altura = Math.max(altura(filhoEsquerdo.esquerda), altura(filhoEsquerdo.direita)) + 1;

    return filhoEsquerdo;

  }

  // função responsável por rotacinar para a esquerda
  private Node<T> rotacaoEsquerda(Node<T> pai) {

    Node<T> filhoDireita = pai.direita;
    pai.direita = filhoDireita.esquerda;
    filhoDireita.esquerda = pai;

    // atualizando as alturas
    pai.altura = Math.max(altura(pai.esquerda), altura(pai.direita)) + 1;
    filhoDireita.altura = Math.max(altura(filhoDireita.esquerda), altura(filhoDireita.direita)) + 1;

    return filhoDireita;

  }

  // função para obter o fator de balanceamento, considerando esquerda como
  // positivo
  private int fatorBalanceamento(Node<T> N) {
    if (is_empty(N)) {
      return 0;
    }

    return altura(N.esquerda) - altura(N.direita);

  }

  private boolean is_empty(Node<T> raiz) {
    return raiz == null;
  }

  // função para rotacionar a árvore
  private Node<T> rotacionarArvore(Node<T> raiz, T tipo) {

    if (is_empty(raiz)) {
      return raiz;
    }

    int fatorBalanco = fatorBalanceamento(raiz);

    if (fatorBalanco > 1) {

      if (tipo.getId() < raiz.esquerda.tipo.getId()) { // neste caso ocorre uma rotação LL

        return rotacaoDireita(raiz);

      } else {
        raiz.esquerda = rotacaoEsquerda(raiz.esquerda); // neste caso ocorre uma rotação LR;
        return rotacaoDireita(raiz);
      }

    }

    if (fatorBalanco < -1) {

      if (tipo.getId() > raiz.direita.tipo.getId()) { // neste caso ocorre uma rotação RR
        return rotacaoEsquerda(raiz);
      } else {
        raiz.direita = rotacaoDireita(raiz.direita); // neste caso ocorre uma rotação RL
        return rotacaoEsquerda(raiz);
      }

    }

    return raiz; // caso o node já esteja balanceado

  }

  public void inserirEntidade(T tipo) throws IllegalArgumentException {
    this.root = inserir(tipo, this.root);
  }

  // função recursiva para inserir na árvore;
  private Node<T> inserir(T tipo, Node<T> raiz) throws IllegalArgumentException {

    if (is_empty(raiz)) {
      return new Node<T>(tipo);
    }

    if (tipo.getId() < raiz.tipo.getId()) { // inserindo no ramo esquerdo da árvore

      raiz.esquerda = inserir(tipo, raiz.esquerda);

    } else if (tipo.getId() > raiz.tipo.getId()) {
      raiz.direita = inserir(tipo, raiz.direita); // inserindo no ramo direito da árvore

    } else { // caso a entidade já exista na coleção
      throw new IllegalArgumentException(
          String.format("Erro: Entidade existente"));
    }

    raiz.altura = Math.max(altura(raiz.esquerda), altura(raiz.direita)) + 1; // atualizando a altura

    return rotacionarArvore(raiz, tipo);

  }

  // função recursiva para remover uma entidade da árvore
  // função remove por atualização de ponteiros

  public void removerEntidade(T tipo) throws IllegalArgumentException {
    this.root = remover(tipo, this.root);
  }

  private Node<T> remover(T tipo, Node<T> raiz) throws IllegalArgumentException {

    if (is_empty(raiz)) {
      throw new IllegalArgumentException("Erro: Não é possível remover, pois o banco de dados está vazio.");
    }

    Node<T> guardarRaiz = raiz;

    // buscando o id na árvore
    if (tipo.getId() < raiz.tipo.getId()) {
      raiz.esquerda = remover(tipo, raiz.esquerda);
    } else if (tipo.getId() > raiz.tipo.getId()) {
      raiz.direita = remover(tipo, raiz.direita);
    } else {

      // neste caso o id foi encontrado

      if (raiz.direita == null || raiz.esquerda == null) { // caso o nó a ser removido tenha um filho ou nenhum

        guardarRaiz = raiz.esquerda != null ? raiz.esquerda : raiz.direita;
        System.gc(); // chamando o coletor de lixo

      } else { // caso o nó a ser removido tenha dois filhos

        Node<T> anteriorGuardarRaiz = null;
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
    return rotacionarArvore(guardarRaiz, tipo);
  }

  public T pesquisarEntidade(T tipo) {
    return pesquisar(tipo.getId(), this.root);
  }

  public T pesquisarEntidadePorId(Long id) {
    return pesquisar(id, this.root);
  }

  private T pesquisar(Long id, Node<T> raiz) {
    if (is_empty(raiz)) { // caso base, entidade não encontrado
      return null;
    }

    if (id < raiz.tipo.getId()) {
      return pesquisar(id, raiz.esquerda); // procurando nos ramos da esquerda
    } else if (id > raiz.tipo.getId()) {
      return pesquisar(id, raiz.direita); // procurando nos ramos da direita
    } else {
      return raiz.tipo; // caso tenha achado a entidade na coleção
    }

  }

  // função recursiva para atualizar uma entidade na coleção

  public void atualizarEntidade(T tipo) throws IllegalArgumentException {
    this.root = atualizar(tipo, this.root);
  }

  private Node<T> atualizar(T tipo, Node<T> raiz) throws IllegalArgumentException {

    if (is_empty(raiz)) {
      throw new IllegalArgumentException(String.format(
          "Erro: Não foi possivél atualizar a Entidade de ID: %d, porque o banco de dados está vazio.", tipo.getId()));
    }

    if (tipo.getId() < raiz.tipo.getId()) { // procurando no ramo da esquerda
      raiz.esquerda = atualizar(tipo, raiz.esquerda);

    } else if (tipo.getId() > raiz.tipo.getId()) { // procurando no ramo da direita
      raiz.direita = atualizar(tipo, raiz.direita);

    } else {
      if (raiz.tipo.equals(tipo)) {
        raiz.tipo = tipo;
      } else {
        throw new IllegalArgumentException(
            String.format("Não foi possivel atualizar a Entidade de ID: %d", tipo.getId()));
      }
    }

    return raiz;

  }

  public List<T> toList() {
    return preOrder(this.root);
  }

  private List<T> preOrder(Node<T> raiz) {
    List<T> tipos = new ArrayList<>();
    if (raiz != null) {
      tipos.add(raiz.tipo);
      tipos.addAll(preOrder(raiz.esquerda));
      tipos.addAll(preOrder(raiz.direita));
    }
    return tipos;
  }

}
