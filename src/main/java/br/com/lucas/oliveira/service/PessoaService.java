package br.com.lucas.oliveira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.oliveira.dto.PessoaDTO;
import br.com.lucas.oliveira.exception.EntidadeNulaException;
import br.com.lucas.oliveira.model.Pessoa;
import br.com.lucas.oliveira.repository.PessoaRepository;
import br.com.lucas.oliveira.util.ArvoreAvl;
import jakarta.annotation.PostConstruct;

@Service
public class PessoaService {

  private ArvoreAvl<Pessoa> arvoreAvl;

  @Autowired
  private PessoaRepository pessoaRepository;

  @PostConstruct
  private void carregarArvore() {
    arvoreAvl = new ArvoreAvl<>();
    pessoaRepository.findAll().forEach(pessoa -> arvoreAvl.inserirEntidade(pessoa));
  }

  /*
   * Função que lista todas as pessoas
   * 
   * @return List<PessoaDTO> - Lista de pessoas
   * 
   * @throws EntidadeNulaException - Caso a pessoa seja nula
   */
  public List<PessoaDTO> listar() throws EntidadeNulaException {
    return arvoreAvl.toList().stream().map(PessoaDTO::toDTO).toList();
  }

  /*
   * Função que busca uma pessoa pelo id
   * 
   * @param pessoaId - Id da pessoa
   * 
   * @return PessoaDTO - Pessoa encontrada
   * 
   * @throws EntidadeNulaException - Caso a pessoa seja nula
   */

  public PessoaDTO buscar(Long pessoaId) throws EntidadeNulaException {

    Pessoa pessoa = arvoreAvl.pesquisarEntidadePorId(pessoaId);

    if (pessoa == null) {
      throw new EntidadeNulaException("Pessoa não encontrada");
    }

    return PessoaDTO.toDTO(pessoa);

  }

  /*
   * Função que busca todas as pessoas logadas
   * 
   * @param status - Status da pessoa
   * 
   * @return List<PessoaDTO> - Lista de pessoas logadas
   * 
   * @throws EntidadeNulaException - Caso a pessoa seja nula
   */
  public List<PessoaDTO> buscarLogados(boolean status) throws EntidadeNulaException {

    try {

      return arvoreAvl.toList().stream()
          .filter(pessoa -> pessoa.getContaBiblioteca().getLogado() == status)
          .map(PessoaDTO::toDTO).toList();

    } catch (IllegalArgumentException e) {
      throw new EntidadeNulaException("Pessoa não pode ser nula");
    }

  }

  /*
   * Função que busca se a pessoa está logada
   * 
   * @param id - Id da pessoa
   * 
   * @return boolean - Se a pessoa está logada
   * 
   * @throws EntidadeNulaException - Caso a pessoa seja nula
   */

  public boolean buscarLogado(Long id) throws EntidadeNulaException {

    Pessoa pessoa = arvoreAvl.pesquisarEntidadePorId(id);

    if (pessoa == null) {
      throw new EntidadeNulaException("Pessoa não encontrada");
    }

    return pessoa.getContaBiblioteca().getLogado();

  }

}
