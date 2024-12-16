package com.lucas.oliveira.pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// classe responsável pela conta da biblioteca
public class ContaBiblioteca {

  private double debito;
  private Integer idLivroAtualEmprestado;
  private String dataVencimentoEmprestimo;
  private int quantidadeLivrosEmprestados;

  private static final int PRAZO_ENTREGA_DIAS = 8;

  public ContaBiblioteca(Integer IdLivro) {

    this.debito = 0;
    this.idLivroAtualEmprestado = IdLivro;
    this.dataVencimentoEmprestimo =
        setDataVencimentoEmprestimo(PRAZO_ENTREGA_DIAS);
    this.quantidadeLivrosEmprestados = 0;
  }

  private void verificarDebito(double debito) throws IllegalArgumentException {
    if (debito < 0) {
      throw new IllegalArgumentException("Valor de débito inválido.");
    }
  }

  public double getDebito() { return this.debito; }

  public void setDebito(double debito) throws IllegalArgumentException {
    verificarDebito(debito);

    this.debito += debito;
  }

  public void pagarDebito(double valor) throws IllegalArgumentException {

    verificarDebito(valor);

    this.debito -= valor;
  }

  private void verificarLivroEmprestado(Object obj) throws RuntimeException {

    if (obj == null) {
      throw new RuntimeException("Nenhum livro foi emprestado no momento.");
    }
  }

  public int getIdLivro() throws RuntimeException {
    verificarLivroEmprestado(this.idLivroAtualEmprestado);
    return this.idLivroAtualEmprestado;
  }

  // função para emprestar livro
  public void emprestarLivro(int id) throws RuntimeException {
    if (this.debito < 0) {
      throw new RuntimeException(
          "Você está com saldo devedor, por favor resolva suas pedências");
    }

    if (this.idLivroAtualEmprestado != null) {
      throw new RuntimeException("Você já tem livro emprestado, por favor, "
                                 +
                                 "devolva para continuar o empréstimo atual.");
    }

    this.quantidadeLivrosEmprestados++;
    this.idLivroAtualEmprestado = id;
    setDataVencimentoEmprestimo(PRAZO_ENTREGA_DIAS);
  }

  // função para devolver o livro
  public void devolverLivro(int id)
      throws IllegalArgumentException, RuntimeException {
    verificarLivroEmprestado(
        this.idLivroAtualEmprestado); // verifica se tem livro emprestado

    if (this.idLivroAtualEmprestado != id) { // verifica se são iguais
      throw new RuntimeException(
          "O Livro que você quer devolver, não é o emprestado");
    }

    this.idLivroAtualEmprestado =
        null; // indicando que não tem livro emprestado
    this.dataVencimentoEmprestimo = null;
  }

  // função para obter a data de devolução do livro

  public String getDataVencimentoEmprestimo() throws RuntimeException {
    verificarLivroEmprestado(this.idLivroAtualEmprestado);
    return this.dataVencimentoEmprestimo;
  }

  // função para ajustar a data de devolução do livro
  private String setDataVencimentoEmprestimo(int tempoEmprestimo) {

    LocalDate dataObj = LocalDate.now();

    // dataObj.plusDays(8);

    DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    return dataObj.plusDays(tempoEmprestimo).format(formatarData);
  }

  public int getQuantidadeLivrosEmprestados() {
    return this.quantidadeLivrosEmprestados;
  }
}
