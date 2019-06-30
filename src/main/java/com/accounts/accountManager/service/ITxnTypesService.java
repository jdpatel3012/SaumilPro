package com.accounts.accountManager.service;

import java.util.List;

import javax.validation.Valid;

import com.accounts.accountManager.model.TxnTypes;;

public interface ITxnTypesService {

	List<TxnTypes> fetchAllTxnTypes();

	TxnTypes saveTxnType(@Valid TxnTypes txnTypes);
	
	TxnTypes updateTxnType(@Valid TxnTypes txnTypes);
	
	boolean deleteTxnType(String id);
	
	boolean isAvailable(String id);
}
