package com.accounts.accountManager.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.accountManager.model.UserAccounts;

@Repository
public interface UserAccountsDao extends CrudRepository<UserAccounts,String>{

	@Query("select userAccount from UserAccounts userAccount where userAccount.id=?1")
	UserAccounts findUserAccountById(String id);
}
