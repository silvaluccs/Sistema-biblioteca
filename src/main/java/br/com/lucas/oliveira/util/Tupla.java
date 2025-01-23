package br.com.lucas.oliveira.util;

public class Tupla<F, S> {

  private F primeiro;
  private S secondo;

  public Tupla(F primeiro, S secondo) {
    this.primeiro = primeiro;
    this.secondo = secondo;
  }

  public F getPrimeiro() { return this.primeiro; }

  public S getSecond() { return this.secondo; }

  public void setPrimeiro(F primeiro) { this.primeiro = primeiro; }
}
