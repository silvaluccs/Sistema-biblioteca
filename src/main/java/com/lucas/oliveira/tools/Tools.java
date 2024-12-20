package com.lucas.oliveira.tools;

import java.io.IOException;

public class Tools {

  // Função para limpar a tela
  public static void clearConsole() {
    try {
      String os = System.getProperty("os.name").toLowerCase();
      if (os.contains("win")) {
        // Comando para Windows
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        // Comando para Unix/Linux/MacOS
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (IOException | InterruptedException e) {
      System.out.println("Erro ao tentar limpar a tela: " + e.getMessage());
    }
  }

  // Função para congelar o programa por 10 segundos
  public static void freezeProgram() {
    try {
      System.out.println("Congelando o programa por 10 segundos...");
      Thread.sleep(10000); // Congela por 10.000 milissegundos (10 segundos)
    } catch (InterruptedException e) {
      System.out.println("A interrupção ocorreu: " + e.getMessage());
    }
  }
}
