package com.accounts.accountManager.service;

import java.util.List;

import javax.validation.Valid;

import com.accounts.accountManager.model.UserCategories;

public interface IUserCategoriesService {

	List<UserCategories> fetchAllUserCategories();

	UserCategories saveUserCategory(@Valid UserCategories userCategories);
	
	UserCategories updateUserCategory(@Valid UserCategories userCategories);
	
	void deleteUserCategory(String id);
}
