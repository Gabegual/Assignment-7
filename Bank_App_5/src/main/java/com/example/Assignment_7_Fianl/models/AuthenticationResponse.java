package com.example.Assignment_7_Fianl.models;

public class AuthenticationResponse {

	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

}
