package com.accounts.accountManager.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.IUserTxnsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/api/userTxns")
public class UserTxnsController {

	@Autowired
	IUserTxnsService iUserTxnsService;

	@GetMapping
	public ResponseEntity<List<UserTxns>> fetchAllUserTxns() {
		List<UserTxns> userTxns = iUserTxnsService.fetchAllUserTxns();
		return new ResponseEntity<List<UserTxns>>(userTxns, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserTxns> saveUserTxn(@RequestParam(value = "data") String userTxnJsonData,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		UserTxns userTxns = null;
		try {
			userTxns = new ObjectMapper().readValue(userTxnJsonData, UserTxns.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UserTxns userTxns2 = iUserTxnsService.saveUserTxns(userTxns, file);
		return new ResponseEntity<UserTxns>(userTxns2, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserTxns> UpdateUserTxn(@RequestParam(value = "data") String userTxnJsonData,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		UserTxns userTxns = null;
		try {
			userTxns = new ObjectMapper().readValue(userTxnJsonData, UserTxns.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UserTxns userTxns2 = iUserTxnsService.UpdateUserTxns(userTxns, file);
		return new ResponseEntity<UserTxns>(userTxns2, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<UserTxns> deleteUserTxn(String id) {
		iUserTxnsService.deleteUserTxn(id);
		return new ResponseEntity<UserTxns>(HttpStatus.OK);
	}
}
