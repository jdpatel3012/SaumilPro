package com.accounts.accountManager.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accountManager.dao.UserAccountsDao;
import com.accounts.accountManager.dao.UserTxnsDao;
import com.accounts.accountManager.model.UserAccounts;
import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.IUserAccountsService;

@Service
public class UserAccountsServiceImpl implements IUserAccountsService {

	@Autowired
	UserAccountsDao userAccountsDao;
	
	@Autowired
	UserTxnsDao userTxnsDao;

	@Override
	public List<UserAccounts> fetchAllUserAccounts() {
		return (List<UserAccounts>) userAccountsDao.findAll();
	}

	@Override
	public UserAccounts saveUserAccount(@Valid UserAccounts userAccounts) {
		UUID uuid = UUID.randomUUID();
		userAccounts.setID(uuid.toString());
		return userAccountsDao.save(userAccounts);
	}

	@Override
	public UserAccounts updateUserAccount(@Valid UserAccounts userAccounts) {
		UserAccounts userAccounts2 = userAccountsDao.findUserAccountById(userAccounts.getID());
		userAccounts2.setAcc_no(userAccounts.getAcc_no());
		userAccounts2.setActive(userAccounts.getActive());
		userAccounts2.setName(userAccounts.getName());
		return userAccountsDao.save(userAccounts2);
	}

	@Override
	public void deleteTxnType(String id) {
		UserTxns userTxns = userTxnsDao.findUserTxnByAccountId(id);
		if (userTxns == null) {
			userAccountsDao.deleteById(id);
		}
	}

}
