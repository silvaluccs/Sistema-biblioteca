package com.lucas.oliveira.login;

import com.lucas.oliveira.pessoa.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

  private Login login;
  private Pessoa pessoa1;

  @BeforeEach
  public void setup() {
    login = new Login();
    Pessoa pessoa1 = new Pessoa("Lucas", 19, "xxx.xxx.xxx-xx", 1);
    login.setNovoUsuario("Lucas", "bahia", pessoa1);
  }

  @Test
  public void novoUsuarioRegistradoTest() {

    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> login.setNovoUsuario("Lucas", "bahia", pessoa1));
  }

  @Test
  public void getPessoaNaoExisteTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> login.getPessoa("Joao", "hajd"));
  }

  @Test
  public void getPessoaSenhaIncorretaTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> login.getPessoa("Lucas", "adad"));
  }

  @Test
  public void getPessoaTest() {
    Pessoa pessoaEncontrada = login.getPessoa("Lucas", "bahia");

    Assertions.assertTrue(pessoa1.equals(pessoaEncontrada));
  }

  @Test
  public void loginTest() {

    boolean loginUsuario = login.loginUsuario("Lucas", "bahia");

    Assertions.assertTrue(loginUsuario);
  }

  @Test
  public void mudarSenhaComSenhaNovaIgualAnteriorTest() {

    boolean mudouSenha = login.mudarSenha("Lucas", "bahia", "bahia");

    Assertions.assertFalse(mudouSenha);
  }

  @Test
  public void mudarSenhaTest() {
    boolean mudouSenha = login.mudarSenha("Lucas", "bahia", "bahia123");
    Assertions.assertTrue(mudouSenha);
  }

  @Test
  public void getPessoaDepoisDeMudarSenha() {

    login.mudarSenha("Lucas", "bahia", "bahia123");

    Pessoa pessoaEncontrada = login.getPessoa("Lucas", "bahia123");

    Assertions.assertTrue(pessoa1.equals(pessoaEncontrada));
  }
}
