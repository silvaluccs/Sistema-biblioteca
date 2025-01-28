package br.com.lucas.oliveira.exception;

public class EntidadeNulaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntidadeNulaException(String message) {
		super(message);
	}

}
