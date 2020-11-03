package com.policy.policy.exception;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.policy.policy.reponses.Response;
import com.policy.policy.services.ErrorMessage;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request) {
		
		String errorDescription = e.getLocalizedMessage();
		if(errorDescription == null) errorDescription = e.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders() ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
