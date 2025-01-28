package br.com.lucas.oliveira.dto;

import br.com.lucas.oliveira.model.Pessoa;
import lombok.Data;

@Data
public class PessoaDTO {
    private String nome;
    private Integer idade;
    private ContaBibliotecaDTO contaBiblioteca;
    
	public static PessoaDTO toDTO(Pessoa pessoa) throws IllegalArgumentException {
		
		if (pessoa == null) {
			throw new IllegalArgumentException("Pessoa não pode ser nula");
		}
		
        PessoaDTO pessoaDTO = new PessoaDTO();
        
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setIdade(pessoa.getIdade());
        pessoaDTO.setContaBiblioteca(new ContaBibliotecaDTO());
        pessoaDTO.getContaBiblioteca().setLogado(pessoa.getContaBiblioteca().getLogado());
        return pessoaDTO;
    }
    
    @Data
    public static class ContaBibliotecaDTO {
        private boolean logado;
    }
}
