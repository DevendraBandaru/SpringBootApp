package org.jsp.SpringWorkShop.exception;

import org.jsp.SpringWorkShop.dto.ResponceStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class UserBootAppExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handleNotFoundExceptionEntity(IdNotFoundException e){
		ResponceStructure<String> structure=new ResponceStructure<>();
		structure.setBody("User not found");
		structure.setMessage(e.getMessage());
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.NOT_FOUND);		
	}
	@ExceptionHandler(InvaidCredentialException.class)
	public ResponseEntity<ResponceStructure<String>> handleInvalidCredentialException(InvaidCredentialException e){
		ResponceStructure<String> structure=new ResponceStructure<>();
		structure.setBody("invalid phone or email or passowrd");
		structure.setMessage(e.getMessage());
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.NOT_FOUND);		
	}

}
