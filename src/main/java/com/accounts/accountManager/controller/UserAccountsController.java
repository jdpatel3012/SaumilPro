package com.accounts.accountManager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accountManager.model.UserAccounts;
import com.accounts.accountManager.service.IUserAccountsService;

@RestController
@CrossOrigin
@RequestMapping("/api/userAccounts")
public class UserAccountsController {

	@Autowired
	IUserAccountsService iUserAccountService;

	@GetMapping
	public ResponseEntity<List<UserAccounts>> fetchAllUserAccounts() {
		List<UserAccounts> userAccounts = iUserAccountService.fetchAllUserAccounts();
		return new ResponseEntity<List<UserAccounts>>(userAccounts, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserAccounts> saveUserAccount(@Valid @RequestBody UserAccounts userAccounts) {
		UserAccounts userAccounts2 = iUserAccountService.saveUserAccount(userAccounts);
		return new ResponseEntity<UserAccounts>(userAccounts2, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserAccounts> updateUserAccount(@Valid @RequestBody UserAccounts userAccounts) {
		UserAccounts userAccounts2 = iUserAccountService.updateUserAccount(userAccounts);
		return new ResponseEntity<UserAccounts>(userAccounts2, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<UserAccounts> deleteUserAccount(@Valid @RequestBody String id) {
		iUserAccountService.deleteTxnType(id);
		return new ResponseEntity<UserAccounts>(HttpStatus.OK);
	}
}
