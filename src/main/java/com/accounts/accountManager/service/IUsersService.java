package com.accounts.accountManager.service;

import java.util.List;

import javax.validation.Valid;

import com.accounts.accountManager.model.Users;

public interface IUsersService {

	List<Users> fetchAllUsers();

	Users saveUser(@Valid Users users);
}
