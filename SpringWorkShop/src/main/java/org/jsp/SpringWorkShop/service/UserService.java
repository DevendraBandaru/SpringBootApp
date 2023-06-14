package org.jsp.SpringWorkShop.service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringWorkShop.dao.UserDao;
import org.jsp.SpringWorkShop.dto.ResponceStructure;
import org.jsp.SpringWorkShop.dto.User;
import org.jsp.SpringWorkShop.exception.IdNotFoundException;
import org.jsp.SpringWorkShop.exception.InvaidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponceStructure<User>> saveUser(User user) {
	
		ResponceStructure<User> structure = new ResponceStructure<User>();
		structure.setMessage("user registered successfully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponceStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<User>> updateUser(User user) {
		ResponceStructure<User> structure = new ResponceStructure<User>();
		structure.setMessage("user updated successfully");
		structure.setBody(dao.updateUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponceStructure<User>> findUser(int id) {
		ResponceStructure<User> structure = new ResponceStructure<User>();
		Optional<User> recUser = dao.findUser(id);
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User find");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.OK);
		}
//		structure.setBody(null);
//		structure.setMessage("user not found");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.NOT_FOUND);
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponceStructure<List<User>>> findAll() {
		ResponceStructure<List<User>> structure = new ResponceStructure<>();
		structure.setBody(dao.findAll());
		structure.setMessage("all users are displayed");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponceStructure<List<User>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponceStructure<String>> deleteUser(int id) {
		ResponceStructure<String> structure = new ResponceStructure<>();
		Optional<User> recUser = dao.findUser(id);
		if (recUser.isPresent()) {
			dao.deleteUser(id);
			structure.setBody("user deleted");
			structure.setMessage("user found");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.NOT_FOUND);
		}
		structure.setBody("user not deleted");
		structure.setMessage("user not fund");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	public ResponseEntity<ResponceStructure<User>> verifyUser(long phone,String password){
		ResponceStructure<User> structure=new ResponceStructure<>();
		Optional<User> recUser=dao.verifyUser(phone, password);
		if(recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("USer is verified  successfully");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.OK);
		}
//		structure.setBody(null);
//		structure.setMessage("invlaid phone or password");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.NOT_FOUND);
		throw new InvaidCredentialException();
	}
	
	public ResponseEntity<ResponceStructure<User>> verifyUser(String email,String password){
		ResponceStructure<User> structure=new ResponceStructure<>();
		Optional<User> recUser=dao.verifyUser(email, password);
		if(recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("USer is verified  successfully");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.OK);
		}
//		structure.setBody(null);
//		structure.setMessage("invlaid email or password");
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponceStructure<User>>(structure,HttpStatus.NOT_FOUND);
		throw new InvaidCredentialException();
	}
	
}
