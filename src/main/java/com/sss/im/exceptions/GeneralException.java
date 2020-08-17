package com.sss.im.exceptions;

import org.springframework.http.ResponseEntity;

import com.sss.im.exceptions.handlers.GlobalExceptionResponse;

public class GeneralException extends RuntimeException{
	
	private static final long serialVersionUID = -6359503123304057854L;

	public   ResponseEntity<GlobalExceptionResponse> getErrorResponse(){
		ResponseEntity<GlobalExceptionResponse> entity = ResponseEntity.status(500).body(new GlobalExceptionResponse("500","Exception ocurred"));
		return entity;
	}
	
}