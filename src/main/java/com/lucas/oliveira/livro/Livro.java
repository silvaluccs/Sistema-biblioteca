package com.lucas.oliveira.livro;

public class Livro {

  private String nomeAutor;
  private String titulo;
  private Integer anoPublicao;
  private String ISNB;
  private Integer numeroPaginas;
  private Integer quantidadeEmprestimos;
  private Integer id;

  // TODO: criar o construtor
  // public Livro(String nomeAutor, String titulo, Integer anoPublicao, Str)

  // Setter para nomeAutor
  public void setNomeAutor(String autor) {
    this.nomeAutor = autor;
  }

  // Getter para nomeAutor
  public String getNomeAutor() {
    return nomeAutor;
  }

  // Setter para titulo
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  // Getter para titulo
  public String getTitulo() {
    return titulo;
  }

  // Setter para anoPublicao
  public void setAnoPublicao(int anoPublicao) {
    this.anoPublicao = anoPublicao;
  }

  // Getter para anoPublicao
  public int getAnoPublicao() {
    return anoPublicao;
  }

  // Setter para ISNB
  public void setISNB(String ISNB) {
    this.ISNB = ISNB;
  }

  // Getter para ISNB
  public String getISNB() {
    return ISNB;
  }

  // Setter para numeroPaginas
  public void setNumeroPaginas(int numeroPaginas) {
    this.numeroPaginas = numeroPaginas;
  }

  // Getter para numeroPaginas
  public int getNumeroPaginas() {
    return numeroPaginas;
  }

  // Setter para quantidadeEmprestimos
  public void setQuantidadeEmprestimos(int quantidadeEmprestimos) {
    this.quantidadeEmprestimos = quantidadeEmprestimos;
  }

  // Getter para quantidadeEmprestimos
  public int getQuantidadeEmprestimos() {
    return quantidadeEmprestimos;
  }

  // Setter para id
  public void setId(int id) {
    this.id = id;
  }

  // Getter para id
  public int getId() {
    return id;
  }
}
