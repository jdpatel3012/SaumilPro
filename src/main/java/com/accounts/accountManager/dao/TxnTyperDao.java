package com.accounts.accountManager.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.accountManager.model.TxnTypes;

@Repository
public interface TxnTyperDao extends CrudRepository<TxnTypes,String> {

	@Query("select txnTypes from TxnTypes txnTypes where txnTypes.id=?1")
	TxnTypes findTxnTypeById(String id);
}
