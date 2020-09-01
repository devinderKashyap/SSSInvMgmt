package com.sss.im.exceptions;

import org.springframework.http.ResponseEntity;

import com.sss.im.exceptions.handlers.GlobalExceptionResponse;

public class UserNotFoundException extends GeneralException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -760438504368335000L;
	String userid ;
	
	public UserNotFoundException(String userid) {
		this.userid=userid;
	}
	@Override
	public ResponseEntity<GlobalExceptionResponse> getErrorResponse() {
		ResponseEntity<GlobalExceptionResponse> entity = ResponseEntity.status(400).body(new GlobalExceptionResponse("400","invalid user id : "+userid));
		return entity;
	}

}
