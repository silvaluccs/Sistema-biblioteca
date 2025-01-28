package br.com.lucas.oliveira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucas.oliveira.dto.PessoaDTO;
import br.com.lucas.oliveira.exception.EntidadeNulaException;
import br.com.lucas.oliveira.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> listar() {
		try {
			return ResponseEntity.ok(pessoaService.listar());
		} 
		catch (EntidadeNulaException e) {
		    return ResponseEntity.badRequest().header("Erro", e.getMessage()).build();
		}
		
	}
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<PessoaDTO> buscar(@PathVariable Long pessoaId) {
		
		try {
			return ResponseEntity.ok(pessoaService.buscar(pessoaId));
		} 
		catch (EntidadeNulaException e) {
			return ResponseEntity.badRequest().header("Erro", e.getMessage()).build();
		}
		
	}
	
	
	@GetMapping("/{pessoaId}/logado")
	public ResponseEntity<String> buscarLogado(@PathVariable Long pessoaId) {
		
		try {
			return ResponseEntity.ok(pessoaService.buscarLogado(pessoaId));
		} catch (EntidadeNulaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	
}
