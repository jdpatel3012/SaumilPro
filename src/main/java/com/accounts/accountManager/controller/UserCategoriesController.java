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

import com.accounts.accountManager.model.UserCategories;
import com.accounts.accountManager.service.IUserCategoriesService;

@RestController
@CrossOrigin
@RequestMapping("/api/userCategories")
public class UserCategoriesController {

	@Autowired
	IUserCategoriesService iUserCategoriesService;

	@GetMapping
	public ResponseEntity<List<UserCategories>> fetchAllUserCategories() {
		List<UserCategories> userCategories = iUserCategoriesService.fetchAllUserCategories();
		return new ResponseEntity<List<UserCategories>>(userCategories, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserCategories> saveUserCategory(@Valid @RequestBody UserCategories userCategories) {
		UserCategories userCategories2 = iUserCategoriesService.saveUserCategory(userCategories);
		return new ResponseEntity<UserCategories>(userCategories2, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserCategories> updateUserCategory(@Valid @RequestBody UserCategories userCategories) {
		UserCategories userCategories2 = iUserCategoriesService.updateUserCategory(userCategories);
		return new ResponseEntity<UserCategories>(userCategories2, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<UserCategories> deleteUserCategory(String id) {
		iUserCategoriesService.deleteUserCategory(id);
		return new ResponseEntity<UserCategories>(HttpStatus.OK);
	}
}
