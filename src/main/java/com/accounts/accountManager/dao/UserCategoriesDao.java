package com.accounts.accountManager.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.accountManager.model.UserCategories;

@Repository
public interface UserCategoriesDao extends CrudRepository<UserCategories,String> {

	@Query("select userCategories from UserCategories userCategories where userCategories.id=?1")
	UserCategories findUserCategoryById(String id);
}
