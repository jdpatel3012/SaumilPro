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
import com.accounts.accountManager.model.TxnTypes;
import com.accounts.accountManager.service.ITxnTypesService;

@RestController
@CrossOrigin
@RequestMapping("/api/txnTypes")
public class TxnTypeController {

	@Autowired
	ITxnTypesService iTxnTypesService;

	@GetMapping
	public ResponseEntity<List<TxnTypes>> fetchAllTxnTypes() {
		List<TxnTypes> txnTypes = iTxnTypesService.fetchAllTxnTypes();
		return new ResponseEntity<List<TxnTypes>>(txnTypes, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TxnTypes> saveTxnType(@Valid @RequestBody TxnTypes txnTypes) {
		TxnTypes txnTypes2 = iTxnTypesService.saveTxnType(txnTypes);
		return new ResponseEntity<TxnTypes>(txnTypes2, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<TxnTypes> updateTxnType(@Valid @RequestBody TxnTypes txnTypes) {
		TxnTypes txnTypes2 = iTxnTypesService.updateTxnType(txnTypes);
		return new ResponseEntity<TxnTypes>(txnTypes2, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<TxnTypes> deleteTxnType(String id) {
		iTxnTypesService.deleteTxnType(id);
		return new ResponseEntity<TxnTypes>(HttpStatus.OK);
	}
}
