package com.lucas.oliveira.pessoa;

public class Pessoa {

  private String nome;
  private int idade;
  private String cpf;
  private ContaBiblioteca contaUsuario;

  public Pessoa(String nome, int idade, String cpf, Integer idLivroEmprestadoAtual) {
    this.nome = nome;
    this.idade = idade;
    this.cpf = cpf;
    contaUsuario = new ContaBiblioteca(idLivroEmprestadoAtual);
  }

  public ContaBiblioteca getContaUsuario() {
    return contaUsuario;
  }

  public Pessoa() {
    this(null, 0, null, null);
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

  private void verificarNumeroValido(int n) throws IllegalArgumentException {
    if (n < -1) {
      throw new IllegalArgumentException("O número digitado é inválido.");
    }
  }

}
