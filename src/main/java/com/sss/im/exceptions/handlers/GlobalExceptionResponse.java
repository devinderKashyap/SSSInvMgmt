package com.sss.im.exceptions.handlers;

public class GlobalExceptionResponse {

	private String status;
	private String description;
	
	public GlobalExceptionResponse(String st,String desc) {
		status=st;
		description=desc;
	}

	public String getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}
	
}
