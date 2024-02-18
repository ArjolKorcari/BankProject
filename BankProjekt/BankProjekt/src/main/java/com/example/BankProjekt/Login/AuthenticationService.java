package com.example.BankProjekt.Login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean isAuthenticate(String username,String password ) {
		
		boolean isValidUsername= username.equalsIgnoreCase("Raiffasen");
		boolean isValidPassword= password.equalsIgnoreCase("1234567");
		
		return isValidPassword && isValidUsername;
		
	}
	
	

}
