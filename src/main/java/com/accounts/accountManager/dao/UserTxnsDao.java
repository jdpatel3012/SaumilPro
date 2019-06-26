package com.accounts.accountManager.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.accountManager.model.UserTxns;

@Repository
public interface UserTxnsDao extends CrudRepository<UserTxns, String> {

	@Query("select userTxns from UserTxns userTxns where userTxns.id=?1")
	UserTxns findUserTxnById(String id);

	@Query("select userTxns from UserTxns userTxns where userTxns.account_id=?1")
	UserTxns findUserTxnByAccountId(String id);

	@Query("select userTxns from UserTxns userTxns where userTxns.category_id=?1")
	UserTxns findUserTxnByCategoryId(String id);

	@Query("select userTxns from UserTxns userTxns where userTxns.txn_type_id=?1")
	UserTxns findUserTxnByTxnTypeId(String id);

	@Query("select userTxns from UserTxns userTxns where userTxns.tag_id=?1")
	UserTxns findUserTxnByTagId(String id);
}
