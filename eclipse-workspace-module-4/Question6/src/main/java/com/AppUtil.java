package com;


import java.util.regex.Pattern;

public class AppUtil {
	
	//Regular expression for validating email
	
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	
	public static boolean isValidEmail(String email) {
		return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
		
		}
	private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])([?=.*A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		public static boolean isValidPassword(String password) {
		return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
		
	}
}

