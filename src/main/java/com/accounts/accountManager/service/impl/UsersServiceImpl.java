package com.accounts.accountManager.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accountManager.dao.UsersDao;
import com.accounts.accountManager.model.Users;
import com.accounts.accountManager.service.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public List<Users> fetchAllUsers() {
		return (List<Users>) usersDao.findAll();
	}

	@Override
	public Users saveUser(@Valid Users users) {
		return usersDao.save(users);
	}

}
