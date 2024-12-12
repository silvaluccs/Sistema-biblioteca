package com.lucas.oliveira.pessoa;

// classe responsável pelo cliente do sistema

public class Pessoa {

  private String nome;
  private int idade;
  private String cpf;
  private int quantidadeLivrosEmprestados;
  private Integer idLivroEmprestadoAtual;

  public Pessoa(String nome, int idade, String cpf, int quantidadeLivrosEmprestados, Integer idLivroEmprestadoAtual) {
    this.nome = nome;
    this.idade = idade;
    this.cpf = cpf;
    this.quantidadeLivrosEmprestados = quantidadeLivrosEmprestados;
    this.idLivroEmprestadoAtual = idLivroEmprestadoAtual;
  }

  public Pessoa() {
    this(null, 0, null, 0, null);
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setIdade(int idade) throws IllegalArgumentException {
    verificarNumeroValido(idade);
    this.idade = idade;
  }

  public int getIdade() {
    return this.idade;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setQuantidadeLivrosEmprestados(int quantidadeLivrosEmprestados) throws IllegalArgumentException {
    verificarNumeroValido(quantidadeLivrosEmprestados);

    if (this.quantidadeLivrosEmprestados < quantidadeLivrosEmprestados) {
      this.quantidadeLivrosEmprestados = quantidadeLivrosEmprestados;
      return;
    }

    throw new IllegalArgumentException("A quantidade de livro emprestado é menor que o total registrado.");

  }

  public int getQuantidadeLivrosEmprestados() {
    return this.quantidadeLivrosEmprestados;
  }

  public void setIdLivroEmprestadoAtual(int idLivroEmprestadoAtual) throws IllegalArgumentException {
    verificarNumeroValido(idLivroEmprestadoAtual);
    this.idLivroEmprestadoAtual = idLivroEmprestadoAtual;
  }

  public Integer getIdLivroEmprestadoAtual() {
    return idLivroEmprestadoAtual;
  }

  private void verificarNumeroValido(int n) throws IllegalArgumentException {
    if (n < -1) {
      throw new IllegalArgumentException("O número digitado é inválido.");
    }
  }

}
