package com.accounts.accountManager.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accountManager.dao.TxnTyperDao;
import com.accounts.accountManager.dao.UserTxnsDao;
import com.accounts.accountManager.model.TxnTypes;
import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.ITxnTypesService;

@Service
public class TxnTypeServiceImpl implements ITxnTypesService {

	@Autowired
	TxnTyperDao txnTypeDao;

	@Autowired
	UserTxnsDao userTxnsDao;

	@Override
	public List<TxnTypes> fetchAllTxnTypes() {
		return (List<TxnTypes>) txnTypeDao.findAll();
	}

	@Override
	public TxnTypes saveTxnType(@Valid TxnTypes txnTypes) {
		UUID uuid = UUID.randomUUID();
		txnTypes.setID(uuid.toString());
		return txnTypeDao.save(txnTypes);
	}

	@Override
	public TxnTypes updateTxnType(@Valid TxnTypes txnTypes) {
		TxnTypes txnTypes2 = txnTypeDao.findTxnTypeById(txnTypes.getID());
		txnTypes2.setName(txnTypes.getName());
		return txnTypeDao.save(txnTypes2);
	}

	@Override
	public void deleteTxnType(String id) {
		UserTxns userTxns = userTxnsDao.findUserTxnByTxnTypeId(id);
		if (userTxns == null) {
			txnTypeDao.deleteById(id);
		}
	}

}
