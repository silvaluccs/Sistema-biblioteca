package br.com.lucas.oliveira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucas.oliveira.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

  @Autowired
  private LivroService livroService;

}
