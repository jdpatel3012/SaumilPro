package com.accounts.accountManager.controller;

import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_ALREADY_EXISTS;
import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_ALREADY_EXISTS_LONG;
import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_DOES_NOT_EXISTS;
import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_DOES_NOT_EXISTS_LONG;
import static com.accounts.accountManager.commons.constants.StringConstants.ERROR_WHILE_DELETING;
import static com.accounts.accountManager.commons.constants.StringConstants.ERROR_WHILE_DELETING_LONG;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.accounts.accountManager.commons.CustomResponseException;
import com.accounts.accountManager.commons.ResponseUtility;
import com.accounts.accountManager.model.UserTags;
import com.accounts.accountManager.service.IUserTagsService;

@RestController
@CrossOrigin
@RequestMapping("/api/userTags")
public class UserTagsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	ResponseUtility responseUtility = new ResponseUtility();

	@Autowired
	IUserTagsService iUserTagsService;

	@GetMapping
	public ResponseEntity<Object> fetchAllUserTags() {
		List<UserTags> userTags = iUserTagsService.fetchAllUserTags();
		return responseUtility.successResponse(userTags);
	}

	@PostMapping
	public ResponseEntity<Object> saveUserTag(@Valid @RequestBody UserTags userTags) throws CustomResponseException {
		UserTags userTags2 = iUserTagsService.saveUserTag(userTags);
		if (userTags2 == null)
			throw new CustomResponseException(HttpStatus.NOT_ACCEPTABLE, ENTRY_ALREADY_EXISTS,
					"tag id " + ENTRY_ALREADY_EXISTS_LONG);
		return responseUtility.successResponse(userTags2);
	}

	@PutMapping
	public ResponseEntity<Object> updateUserTag(@Valid @RequestBody UserTags userTags) throws CustomResponseException {
		UserTags userTags2 = iUserTagsService.updateUserTag(userTags);
		if (userTags2 == null)
			throw new CustomResponseException(HttpStatus.NOT_FOUND, ENTRY_DOES_NOT_EXISTS,
					"tag id " + ENTRY_DOES_NOT_EXISTS_LONG);
		return responseUtility.successResponse(userTags2);
	}

	@DeleteMapping
	public ResponseEntity<Object> deleteUserTag(@Valid @RequestBody String id) throws CustomResponseException {
		if (iUserTagsService.deleteUserTag(id))
			return responseUtility.successResponse(null);
		else
			throw new CustomResponseException(HttpStatus.NOT_FOUND, ERROR_WHILE_DELETING, ERROR_WHILE_DELETING_LONG);
	}
}
