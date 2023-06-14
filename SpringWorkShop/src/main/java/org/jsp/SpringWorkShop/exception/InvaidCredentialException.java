package org.jsp.SpringWorkShop.exception;

public class InvaidCredentialException extends RuntimeException{
	@Override
	public String getMessage() {
		return "invalid credentials";
	}

}
