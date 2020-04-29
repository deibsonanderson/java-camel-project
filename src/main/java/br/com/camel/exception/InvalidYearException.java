package br.com.camel.exception;

public class InvalidYearException extends Exception {

	private static final long serialVersionUID = 2321750871082124116L;

	public InvalidYearException(String message) {
		super(message);
	}
}
