package com.accounts.accountManager.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.accounts.accountManager.dao.UserTxnsDao;
import com.accounts.accountManager.model.UserTxns;
import com.accounts.accountManager.service.IUserTxnsService;

import javassist.bytecode.ByteArray;

@Service
public class UserTxnsServiceImpl implements IUserTxnsService {

	@Autowired
	UserTxnsDao userTxnsDao;

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
		return userTxnsDao.save(userTxns);
	}

	@Override
	public UserTxns UpdateUserTxns(@Valid UserTxns userTxns, MultipartFile file) {
		UserTxns userTxns2 = userTxnsDao.findUserTxnById(userTxns.getID());
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
	public void deleteUserTxn(String id) {
		userTxnsDao.deleteById(id);
	}

}
