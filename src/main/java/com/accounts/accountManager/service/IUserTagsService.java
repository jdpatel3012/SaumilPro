package com.accounts.accountManager.service;

import java.util.List;

import javax.validation.Valid;

import com.accounts.accountManager.model.UserTags;

public interface IUserTagsService {

	List<UserTags> fetchAllUserTags();

	UserTags saveUserTag(@Valid UserTags userTags);

	UserTags updateUserTag(@Valid UserTags userTags);

	boolean deleteUserTag(String id);

	boolean isAvailable(String id);
}
