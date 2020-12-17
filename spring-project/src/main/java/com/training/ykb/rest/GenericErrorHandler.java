package com.training.ykb.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.ykb.rest.error.ErrorObj;

@RestControllerAdvice
public class GenericErrorHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorObj handleIllegalArgumentException(IllegalArgumentException ex) {
		ErrorObj error = new ErrorObj().boundedContext("BD").microservice("MyService").subDomain("CRM")
				.description(ex.getMessage()).cause(101);
		// error.setDescription(ex.getMessage());
		return error;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObj> handleException(Exception ex) {
		ErrorObj error = new ErrorObj().boundedContext("BD").microservice("MyService").subDomain("CRM")
				.description(ex.getMessage()).cause(101);
		// error.setDescription(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
