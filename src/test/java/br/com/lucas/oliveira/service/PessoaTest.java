package br.com.lucas.oliveira.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.lucas.oliveira.model.Pessoa;

// classe para testar a classe pessoa e suas funcionabilidades
public class PessoaTest {

  private Pessoa pessoa1;

  @BeforeEach
  public void instanciaPessoa() {
    pessoa1 = new Pessoa("Pedro", 19, "923.232.342-19", 1);
  }

  @Test
  public void DebitoNegativoTest() {

    int debitoInvalido = -1;

    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> pessoa1.getContaUsuario().setDebito(debitoInvalido));
  }

  @Test
  public void obterDataDevolucaoTest() {

    LocalDate dataHoje = LocalDate.now();
    DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    String DataEsperada = dataHoje.plusDays(8).format(formatarData);

    Assertions.assertEquals(
        DataEsperada, pessoa1.getContaUsuario().getDataVencimentoEmprestimo());
  }

  @Test
  public void devolucaoLivroErradoTest() {

    Assertions.assertThrows(
        RuntimeException.class,
        () -> pessoa1.getContaUsuario().devolverLivro(1111));
  }
}
