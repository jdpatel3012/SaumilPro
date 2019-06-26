package com.accounts.accountManager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.accountManager.model.Users;

@Repository
public interface UsersDao extends CrudRepository<Users,String>{

}
