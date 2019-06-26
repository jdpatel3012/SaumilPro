package com.accounts.accountManager.service;

import java.util.List;

import javax.validation.Valid;

import com.accounts.accountManager.model.Backup;

public interface IBackupService {

	List<Backup> fetchAllBackups();
	
	Backup saveBackup(@Valid Backup backup);
}
