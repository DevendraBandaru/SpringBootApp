package org.jsp.SpringWorkShop.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringWorkShop.dto.ResponceStructure;
import org.jsp.SpringWorkShop.dto.User;
import org.jsp.SpringWorkShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/users")
	public ResponseEntity<ResponceStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	@PutMapping("/users")
	public ResponseEntity<ResponceStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	@GetMapping("users/{id}")
	public ResponseEntity<ResponceStructure<User>> findUser(@PathVariable int id) {
		return service.findUser(id);
	}
	@GetMapping("/users")
	public ResponseEntity<ResponceStructure<List<User>>> findAll(){
		return service.findAll();
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponceStructure<String>> deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
	@PostMapping("/users/verify-phone")
	public ResponseEntity<ResponceStructure<User>> verifyUser(@RequestParam long phone,@RequestParam String password){
		return service.verifyUser(phone, password);		
	}
	@PostMapping("/users/verify-email")
	public ResponseEntity<ResponceStructure<User>> verifyUser(@RequestParam String email,@RequestParam String password){
		return service.verifyUser(email, password);
			
	}
}
