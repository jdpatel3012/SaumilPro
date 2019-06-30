package com.accounts.accountManager.controller;

import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_ALREADY_EXISTS;
import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_ALREADY_EXISTS_LONG;
import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_DOES_NOT_EXISTS;
import static com.accounts.accountManager.commons.constants.StringConstants.ENTRY_DOES_NOT_EXISTS_LONG;
import static com.accounts.accountManager.commons.constants.StringConstants.ERROR_WHILE_DELETING;
import static com.accounts.accountManager.commons.constants.StringConstants.ERROR_WHILE_DELETING_LONG;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accounts.accountManager.commons.CustomResponseException;
import com.accounts.accountManager.commons.ResponseUtility;
import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.IUserTxnsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/api/userTxns")
public class UserTxnsController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	ResponseUtility responseUtility = new ResponseUtility();

	@Autowired
	IUserTxnsService iUserTxnsService;

	@GetMapping
	public ResponseEntity<Object> fetchAllUserTxns() throws InterruptedException {
		List<UserTxns> userTxns = iUserTxnsService.fetchAllUserTxns();
		return responseUtility.successResponse(userTxns);
	}

	@PostMapping
	public ResponseEntity<Object> saveUserTxn(@RequestParam(value = "data") String userTxnJsonData,
			@RequestParam(value = "file", required = false) MultipartFile file)
			throws CustomResponseException, JsonParseException, JsonMappingException, IOException {
		UserTxns userTxns = new ObjectMapper().readValue(userTxnJsonData, UserTxns.class);
		UserTxns userTxns2 = iUserTxnsService.saveUserTxns(userTxns, file);
		if (userTxns2 == null)
			throw new CustomResponseException(HttpStatus.NOT_ACCEPTABLE, ENTRY_ALREADY_EXISTS,
					"txn id " + ENTRY_ALREADY_EXISTS_LONG);
		return responseUtility.successResponse(userTxns2);
	}

	@PutMapping
	public ResponseEntity<Object> UpdateUserTxn(@RequestParam(value = "data") String userTxnJsonData,
			@RequestParam(value = "file", required = false) MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException, CustomResponseException {
		UserTxns userTxns = new ObjectMapper().readValue(userTxnJsonData, UserTxns.class);
		UserTxns userTxns2 = iUserTxnsService.UpdateUserTxns(userTxns, file);
		if (userTxns2 == null)
			throw new CustomResponseException(HttpStatus.NOT_FOUND, ENTRY_DOES_NOT_EXISTS,
					"txn id " + ENTRY_DOES_NOT_EXISTS_LONG);
		return responseUtility.successResponse(userTxns2);
	}

	@DeleteMapping
	public ResponseEntity<Object> deleteUserTxn(@Valid @RequestBody String id) throws CustomResponseException {
		if (iUserTxnsService.deleteUserTxn(id))
			return responseUtility.successResponse(null);
		else
			throw new CustomResponseException(HttpStatus.NOT_FOUND, ERROR_WHILE_DELETING, ERROR_WHILE_DELETING_LONG);
	}
}
