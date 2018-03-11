package com.monix.work.restController.ExceptionHandler;

public class CompteServiceException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CompteServiceException() {
		super();
	}

	public CompteServiceException(final String message) {
		super(message);
	}
}
