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

import com.accounts.accountManager.model.UserTags;
import com.accounts.accountManager.service.IUserTagsService;

@RestController
@CrossOrigin
@RequestMapping("/api/userTags")
public class UserTagsController {

	@Autowired
	IUserTagsService iUserTagsService;

	@GetMapping
	public ResponseEntity<List<UserTags>> fetchAllUserTags() {
		List<UserTags> userTags = iUserTagsService.fetchAllUserTags();
		return new ResponseEntity<List<UserTags>>(userTags, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserTags> saveUserTag(@Valid @RequestBody UserTags userTags) {
		UserTags userTags2 = iUserTagsService.saveUserTag(userTags);
		return new ResponseEntity<UserTags>(userTags2, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserTags> updateUserTag(@Valid @RequestBody UserTags userTags) {
		UserTags userTags2 = iUserTagsService.updateUserTag(userTags);
		return new ResponseEntity<UserTags>(userTags2, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<UserTags> deleteUserTag(String id) {
		iUserTagsService.deleteUserTag(id);
		return new ResponseEntity<UserTags>(HttpStatus.OK);
	}
}
