package com.lucas.oliveira.main;

import com.lucas.oliveira.login.Login;
import java.util.Scanner;

public class Main {

  private static Login login = new Login();

  private static void loginUsuario() {

    String sair;

    do {
      System.out.println("Olá, bem vindo ao sistema de biblioteca\n");
      System.out.println(
          "Deseja:\n[1] login\n[2] Criar uma nova conta\nEscolha:");

      Scanner sc = new Scanner(System.in);

      int escolhaUsuario = sc.nextInt();

      if (escolhaUsuario != 1 || escolhaUsuario != 2) {
        continue;
      }

      if (escolhaUsuario == 1) {
      }

      sc.close();

    } while (sair.equalsIgnoreCase("sim"));
  }

  public static void main(String[] args) {}
}
