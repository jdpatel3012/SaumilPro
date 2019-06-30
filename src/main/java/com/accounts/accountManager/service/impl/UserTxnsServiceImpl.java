package com.accounts.accountManager.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.accounts.accountManager.dao.UserAccountsDao;
import com.accounts.accountManager.dao.UserTxnsDao;
import com.accounts.accountManager.model.UserAccounts;
import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.IUserTxnsService;

@Service
public class UserTxnsServiceImpl implements IUserTxnsService {

	@Autowired
	UserTxnsDao userTxnsDao;

	@Autowired
	UserAccountsDao userAccountsDao;

	@Override
	public List<UserTxns> fetchAllUserTxns() {
		return (List<UserTxns>) userTxnsDao.findAll();
	}

	@Override
	public UserTxns saveUserTxns(@Valid UserTxns userTxns, MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		userTxns.setID(uuid.toString());
		uuid = UUID.randomUUID();
		userTxns.setTxn_id(uuid.toString());

		if (file != null) {
			try {
				userTxns.setImgType(file.getContentType());
				userTxns.setImgName(file.getOriginalFilename());
				userTxns.setImg(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (userTxns.getAmtCr() > 0 || userTxns.getAmtDr() > 0) {
			UserAccounts userAccounts = userAccountsDao.findUserAccountById(userTxns.getAccount_id());
			userAccounts.setBalance(userAccounts.getBalance() + userTxns.getAmtCr());
			userAccounts.setBalance(userAccounts.getBalance() - userTxns.getAmtDr());
			userAccountsDao.save(userAccounts);
		}
		return userTxnsDao.save(userTxns);
	}

	@Override
	public UserTxns UpdateUserTxns(@Valid UserTxns userTxns, MultipartFile file) {
		UserTxns userTxns2 = userTxnsDao.findUserTxnById(userTxns.getID());
		if (userTxns2 == null)
			return null;
		userTxns2.setAccount_id(userTxns.getAccount_id());
		userTxns2.setAmtCr(userTxns.getAmtCr());
		userTxns2.setAmtDr(userTxns.getAmtDr());
		userTxns2.setCategory_id(userTxns.getCategory_id());
		userTxns2.setDate(userTxns.getDate());
		userTxns2.setExp(userTxns.getExp());
		userTxns2.setNote(userTxns.getNote());
		userTxns2.setTag_id(userTxns.getTag_id());
		userTxns2.setTitle(userTxns.getTitle());
		userTxns2.setTxn_type_id(userTxns.getTxn_type_id());
		if (file != null) {
			try {
				userTxns2.setImgType(file.getContentType());
				userTxns2.setImgName(file.getOriginalFilename());
				userTxns2.setImg(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return userTxnsDao.save(userTxns2);
	}

	@Override
	public boolean deleteUserTxn(String id) {
		if (isAvailable(id)) {
			userTxnsDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean isAvailable(String id) {
		if (userTxnsDao.findUserTxnById(id) != null) {
			return true;
		}
		return false;
	}

}
