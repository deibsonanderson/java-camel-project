package br.com.camel.exception;

public class InvalidNumberException extends Exception {

	private static final long serialVersionUID = 2381750851082134116L;

	public InvalidNumberException(String message) {
		super(message);
	}
}
