package com.lucas.oliveira.main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceGrafica extends JFrame {

  InterfaceGrafica() {

    this.setSize(720, 720);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);

    JPanel telaLogin = new JPanel();
    this.setTitle("Login");
    telaLogin.setSize(720, 720);
    telaLogin.setName("Login");

    JLabel labelLogin = new JLabel("Login");
    labelLogin.setFont(new Font("", Font.PLAIN, 65));
    labelLogin.setBounds(50, 50, 250, 70);
    telaLogin.add(labelLogin);

    this.add(telaLogin);
  }

  public static void main(String[] args) { new InterfaceGrafica(); }
}
