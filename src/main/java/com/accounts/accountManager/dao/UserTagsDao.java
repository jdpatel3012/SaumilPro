package com.accounts.accountManager.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.accountManager.model.UserTags;

@Repository
public interface UserTagsDao extends CrudRepository<UserTags,String> {

	@Query("select userTags from UserTags userTags where userTags.id=?1")
	UserTags findUserTagById(String id);
}
