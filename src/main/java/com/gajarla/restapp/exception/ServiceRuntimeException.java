package com.gajarla.restapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceRuntimeException extends RuntimeException {
	
	private String message;
	private String details;
	
	public ServiceRuntimeException(String message, String details) {
		this.message = message;
		this.details = details;
	}

}
