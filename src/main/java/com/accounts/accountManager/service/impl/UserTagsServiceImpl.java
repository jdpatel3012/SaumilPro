package com.accounts.accountManager.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accountManager.dao.UserTagsDao;
import com.accounts.accountManager.dao.UserTxnsDao;
import com.accounts.accountManager.model.UserTags;
import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.IUserTagsService;

@Service
public class UserTagsServiceImpl implements IUserTagsService {

	@Autowired
	UserTagsDao userTagsDao;

	@Autowired
	UserTxnsDao userTxnsDao;

	@Override
	public List<UserTags> fetchAllUserTags() {
		return (List<UserTags>) userTagsDao.findAll();
	}

	@Override
	public UserTags saveUserTag(@Valid UserTags userTags) {
		UUID uuid = UUID.randomUUID();
		userTags.setID(uuid.toString());
		return userTagsDao.save(userTags);
	}

	@Override
	public UserTags updateUserTag(@Valid UserTags userTags) {
		UserTags userTags2 = userTagsDao.findUserTagById(userTags.getID());
		userTags2.setName(userTags.getName());
		return userTagsDao.save(userTags2);
	}

	@Override
	public void deleteUserTag(String id) {
		UserTxns userTxns = userTxnsDao.findUserTxnByTagId(id);
		if (userTxns == null) {
			userTagsDao.deleteById(id);
		}
	}

}
