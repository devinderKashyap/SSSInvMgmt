package com.sss.im.auth;

public class AuthResponse {
	
	private final String authToken;

	
	public AuthResponse(String authToken) {
		super();
		this.authToken = authToken;
	}


	public String getAuthToken() {
		return authToken;
	}

	

}
