package com.lucas.oliveira.login;

import com.lucas.oliveira.pessoa.Pessoa;
import java.util.HashMap;
import java.util.Map;

// classe para fazer o login do usuario

public class Login {

  private Map<String, Tupla<String, Pessoa>> bancoLoginSenha;

  public Login() { this.bancoLoginSenha = new HashMap<>(); }

  private boolean usuarioExistente(String usuario) {
    return bancoLoginSenha.get(usuario) != null;
  }

  public void setNovoUsuario(String usuario, String senha, Pessoa pessoa)
      throws IllegalArgumentException {

    if (usuarioExistente(usuario)) {
      throw new IllegalArgumentException(
          "Erro: O usuário já existe no banco de dados.");
    }

    Tupla<String, Pessoa> dadosUsuario =
        new Tupla<String, Pessoa>(senha, pessoa);

    bancoLoginSenha.put(usuario, dadosUsuario);
  }

  public Pessoa getPessoa(String usuario, String senha)
      throws IllegalArgumentException {

    if (!usuarioExistente(usuario)) {
      throw new IllegalArgumentException(
          "Erro: Este usuário não existe no banco de dados");
    }

    Tupla<String, Pessoa> dadosUsuario = bancoLoginSenha.get(usuario);

    if (dadosUsuario.getPrimeiro() != senha) {

      throw new IllegalArgumentException("Erro: usuário ou senha incorreto(s)");
    }

    return dadosUsuario.getSecond();
  }

  public boolean loginUsuario(String usuario, String senha) {

    Pessoa pessoaEncotrada = getPessoa(usuario, senha);

    if (pessoaEncotrada != null) {
      return true;
    }
    return false;
  }

  private void deletarUsuario(String usuario) {
    bancoLoginSenha.remove(usuario);
  }

  public boolean mudarSenha(String usuario, String senha, String novaSenha) {

    if (!usuarioExistente(usuario) || senha == novaSenha) {
      return false;
    }

    Tupla<String, Pessoa> dadosUsuario = bancoLoginSenha.get(usuario);

    if (dadosUsuario.getPrimeiro() != senha) {
      return false;
    }

    deletarUsuario(usuario); // excluindo o antigo usuario

    dadosUsuario.setPrimeiro(novaSenha); // mudando a senha

    setNovoUsuario(
        usuario, dadosUsuario.getPrimeiro(),
        dadosUsuario.getSecond()); // configurando o usuario com a nova senha
    return true;
  }
}
