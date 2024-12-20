package com.lucas.oliveira.main;

import com.lucas.oliveira.login.Login;
import com.lucas.oliveira.pessoa.Pessoa;
import com.lucas.oliveira.tools.Tools;
import java.util.Scanner;

public class Main {

  private static Login login = new Login();

  private static Pessoa loginUsuario() {

    boolean sair = false;
    Pessoa usuario = null;

    do {
      System.out.println("Olá, bem vindo ao sistema de biblioteca\n");
      System.out.println(
          "Deseja:\n[1] login\n[2] Criar uma nova conta\nEscolha:");

      Scanner sc = new Scanner(System.in);

      int escolhaUsuario = sc.nextInt();

      if (escolhaUsuario != 1 || escolhaUsuario != 2) {
        continue;
      }

      Tools.clearConsole();

      if (escolhaUsuario == 1) {

        sc.nextLine();

        String username = sc.nextLine();
        sc.nextLine();

        String senha = sc.nextLine();

        boolean loginAutorizado = login.loginUsuario(username, senha);

        usuario = loginAutorizado ? login.getPessoa(username, senha) : null;
      } else {

        String nome, cpf;
        int idade;

        System.out.println("Digite seu nome: ");
        sc.nextLine();
        nome = sc.nextLine();
        sc.nextLine();
        System.out.println("Digite seu cpf: ");
        cpf = sc.nextLine();

        System.out.println("Digite sua idade: ");
        idade = sc.nextInt();

        String username, senha;

        sc.nextLine();
        System.out.println("Digite um nome de usuário: ");
        username = sc.nextLine();

        sc.nextLine();

        System.out.println("Digite uma senha: ");
        senha = sc.nextLine();

        try {
          login.setNovoUsuario(username, senha,
                               new Pessoa(nome, idade, cpf, null));

          usuario = login.getPessoa(username, senha);

        } catch (Exception e) {
          System.out.println(e.getMessage());
          usuario = null;
        }
      }

      if (usuario == null) {
        System.out.println("\nNão foi possível fazer o login, tente novamente "
                           + "em 10 segundos.\n");
        Tools.freezeProgram();
        Tools.clearConsole();
        continue;
      }

      sc.close();
      sair = true;

    } while (!sair);

    return usuario;
  }

  public static void main(String[] args) { Pessoa usuario = loginUsuario(); }
}
