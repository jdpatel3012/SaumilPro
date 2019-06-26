package com.accounts.accountManager.service;

import java.util.List;

import javax.validation.Valid;

import com.accounts.accountManager.model.UserAccounts;

public interface IUserAccountsService {

	List<UserAccounts> fetchAllUserAccounts();

	UserAccounts saveUserAccount(@Valid UserAccounts userAccounts);
	
	UserAccounts updateUserAccount(@Valid UserAccounts userAccounts);
	
	void deleteTxnType(String id);
}
