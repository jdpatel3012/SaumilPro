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
import com.accounts.accountManager.model.UserAccounts;
import com.accounts.accountManager.service.IUserAccountsService;

@RestController
@CrossOrigin
@RequestMapping("/api/userAccounts")
public class UserAccountsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	ResponseUtility responseUtility = new ResponseUtility();

	@Autowired
	IUserAccountsService iUserAccountService;

	@GetMapping
	public ResponseEntity<Object> fetchAllUserAccounts() {
		List<UserAccounts> userAccounts = iUserAccountService.fetchAllUserAccounts();
		return responseUtility.successResponse(userAccounts);
	}

	@PostMapping
	public ResponseEntity<Object> saveUserAccount(@Valid @RequestBody UserAccounts userAccounts)
			throws CustomResponseException {
		UserAccounts userAccounts2 = iUserAccountService.saveUserAccount(userAccounts);
		if (userAccounts2 == null)
			throw new CustomResponseException(HttpStatus.NOT_ACCEPTABLE, ENTRY_ALREADY_EXISTS,
					"account id " + ENTRY_ALREADY_EXISTS_LONG);
		return responseUtility.successResponse(userAccounts2);
	}

	@PutMapping
	public ResponseEntity<Object> updateUserAccount(@Valid @RequestBody UserAccounts userAccounts)
			throws CustomResponseException {
		UserAccounts userAccounts2 = iUserAccountService.updateUserAccount(userAccounts);
		if (userAccounts2 == null)
			throw new CustomResponseException(HttpStatus.NOT_FOUND, ENTRY_DOES_NOT_EXISTS,
					"account id " + ENTRY_DOES_NOT_EXISTS_LONG);
		return responseUtility.successResponse(userAccounts2);
	}

	@DeleteMapping
	public ResponseEntity<Object> deleteUserAccount(@Valid @RequestBody String id) throws CustomResponseException {
		if (iUserAccountService.deleteTxnType(id))
			return responseUtility.successResponse(null);
		else
			throw new CustomResponseException(HttpStatus.NOT_FOUND, ERROR_WHILE_DELETING, ERROR_WHILE_DELETING_LONG);
	}
}
