package com.accounts.accountManager.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accountManager.dao.UserCategoriesDao;
import com.accounts.accountManager.dao.UserTxnsDao;
import com.accounts.accountManager.model.UserCategories;
import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.IUserCategoriesService;

@Service
public class UserCategoriesServiceImpl implements IUserCategoriesService {

	@Autowired
	UserCategoriesDao userCategoriesDao;

	@Autowired
	UserTxnsDao userTxnsDao;

	@Override
	public List<UserCategories> fetchAllUserCategories() {
		return (List<UserCategories>) userCategoriesDao.findAll();
	}

	@Override
	public UserCategories saveUserCategory(@Valid UserCategories userCategories) {
		if (userCategoriesDao.findUserCategoryByName(userCategories.getName()) != null)
			return null;
		UUID uuid = UUID.randomUUID();
		userCategories.setID(uuid.toString());
		return userCategoriesDao.save(userCategories);
	}

	@Override
	public UserCategories updateUserCategory(@Valid UserCategories userCategories) {
		UserCategories userCategories2 = userCategoriesDao.findUserCategoryById(userCategories.getID());
		if (userCategories2 == null)
			return null;
		userCategories2.setName(userCategories.getName());
		userCategories2.setCatIcon(userCategories.getCatIcon());
		return userCategoriesDao.save(userCategories2);
	}

	@Override
	public boolean deleteUserCategory(String id) {
		if (isAvailable(id)) {
			if (userTxnsDao.findUserTxnByCategoryId(id) == 0) {
				userCategoriesDao.deleteById(id);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isAvailable(String id) {
		if (userCategoriesDao.findUserCategoryById(id) != null) {
			return true;
		}
		return false;
	}

}
