package com.sss.im.exceptions.handlers;

import com.sss.im.exceptions.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<GlobalExceptionResponse> handleException(GeneralException e) {
		System.out.println("GlobalExceptionHandler.handleException()"+e);
		return e.getErrorResponse() ;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GlobalExceptionResponse> handleException(Exception e) {
		System.out.println("GlobalExceptionHandler.handleException()"+e);
		return ResponseEntity.status(500).body(new GlobalExceptionResponse("500","Exception ocurred"));
	}
}
