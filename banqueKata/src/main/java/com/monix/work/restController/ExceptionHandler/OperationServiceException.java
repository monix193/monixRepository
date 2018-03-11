package com.monix.work.restController.ExceptionHandler;

public class OperationServiceException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperationServiceException() {
		super();
	}

	public OperationServiceException(final String message) {
		super(message);
	}
}
