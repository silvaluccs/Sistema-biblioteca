package br.com.lucas.oliveira.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lucas.oliveira.dto.PessoaDTO;
import br.com.lucas.oliveira.exception.EntidadeNulaException;
import br.com.lucas.oliveira.model.Pessoa;
import br.com.lucas.oliveira.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	/*
	 * Função que lista todas as pessoas
	 * @return List<PessoaDTO> - Lista de pessoas
	 * @throws EntidadeNulaException - Caso a pessoa seja nula
	 * */
	public List<PessoaDTO> listar() throws EntidadeNulaException {
		
		try {
			return pessoaRepository.listar().stream()
					.map(pessoa -> PessoaDTO.toDTO(pessoa)).toList();
		} catch (IllegalArgumentException e) {
			throw new EntidadeNulaException("Pessoa não pode ser nula");
		}
		
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

		Pessoa pessoa = pessoaRepository.buscar(pessoaId);
		
		if (pessoa == null) {
            throw new EntidadeNulaException("Pessoa não encontrada");
        }
		
		return PessoaDTO.toDTO(pessoa);
		
	}
	
	
	/*
	 * Função que verifica se a pessoa está logada
	 * 
	 * @param id - Id da pessoa
	 * 
	 * @return String - Mensagem informando se a pessoa está logada
	 * 
	 * @throws EntidadeNulaException - Caso a pessoa seja nula
	 */
	
	public String buscarLogado(Long id) throws EntidadeNulaException {
	
		PessoaDTO pessoa = buscar(id);
		
		boolean logado = pessoa.getContaBiblioteca().isLogado();
		
		return String.format("Pessoa %s está %s", pessoa.getNome(), 
				logado ? "logada" : "deslogada");
			
	}
	

}
