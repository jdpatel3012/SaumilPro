package com.accounts.accountManager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accountManager.model.Users;
import com.accounts.accountManager.service.IUsersService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	IUsersService iUsersService;
	
	@GetMapping
	public ResponseEntity<List<Users>> fetchAllUsers() {
		List<Users> users = iUsersService.fetchAllUsers();
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Users> saveUser(@Valid @RequestBody Users users) {
		Users users2 = iUsersService.saveUser(users);
		return new ResponseEntity<Users>(users2, HttpStatus.OK);
	}
}
