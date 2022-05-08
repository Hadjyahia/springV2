package com.example.test.security.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginResponse {

	private String token;
	private String email;

    public UserLoginResponse(String token) {
        this.token = token;
    }
	
}
