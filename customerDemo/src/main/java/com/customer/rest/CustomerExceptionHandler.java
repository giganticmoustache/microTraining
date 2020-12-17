package com.customer.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customer.rest.error.CustomerError;

@RestControllerAdvice
public class CustomerExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomerError handle(final IllegalArgumentException e) {
		return new CustomerError().setId(1).setMessage(e.getMessage())
				.setServiceName(e.getStackTrace()[1].getClassName());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomerError handle(final MethodArgumentNotValidException e) {
		CustomerError error = new CustomerError().setId(1).setMessage(e.getMessage())
				.setServiceName(e.getStackTrace()[1].getClassName());
		Integer id = 1;
		for (ObjectError item : e.getAllErrors()) {
			CustomerError subError = new CustomerError().setId(++id).setMessage(item.toString())
					.setServiceName(item.getClass().getSimpleName());
			error.addError(subError);
		}
		return error;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomerError> handle(Exception e) {
		CustomerError error = new CustomerError().setId(1).setMessage(e.getMessage())
				.setServiceName(e.getStackTrace()[1].getClassName());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
