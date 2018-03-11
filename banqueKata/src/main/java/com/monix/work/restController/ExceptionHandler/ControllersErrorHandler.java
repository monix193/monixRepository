package com.monix.work.restController.ExceptionHandler;

import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;

//@ControllerAdvice
public class ControllersErrorHandler {

	
	/*@ExceptionHandler(Exception.class)
	public  ResponseEntity <ErrorResponse> handleError(Exception e)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage(e.getMessage());
		
		return new ResponseEntity <ErrorResponse> (errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	 
	 
	@ExceptionHandler(JsonMappingException.class)
	public  ResponseEntity <ErrorResponse> handleErrorJsonMappingException(JsonMappingException e)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage("Erreur : Veuiuillez saisir un bon compte ");
		
		return new ResponseEntity <ErrorResponse> (errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public  ResponseEntity <ErrorResponse> handleErrorNullPointerException(NullPointerException e)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage("l'objet rechercher n'existe pas");
		
		return new ResponseEntity <ErrorResponse> (errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	/*@ExceptionHandler(RuntimeException.class)
	public  ResponseEntity <ErrorResponse> handleErrorRuntimeException (RuntimeException e)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage("l'objet rechercher n'existe pas");
		
		return new ResponseEntity <ErrorResponse> (errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
*/
	
}
