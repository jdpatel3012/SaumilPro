package com.accounts.accountManager.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.accounts.accountManager.model.UserTxns;

public interface IUserTxnsService {

	List<UserTxns> fetchAllUserTxns();

	UserTxns saveUserTxns(@Valid UserTxns userTxns, MultipartFile file);

	UserTxns UpdateUserTxns(@Valid UserTxns userTxns, MultipartFile file);

	boolean deleteUserTxn(String id);
	
	boolean isAvailable(String id);
}
