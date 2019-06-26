package com.accounts.accountManager.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.accountManager.dao.BackupDao;
import com.accounts.accountManager.model.Backup;
import com.accounts.accountManager.service.IBackupService;

@Service
public class BackupServiceImpl implements IBackupService {

	@Autowired
	BackupDao backupDao;

	@Override
	public List<Backup> fetchAllBackups() {
		return  (List<Backup>) backupDao.findAll();
	}

	@Override
	public Backup saveBackup(@Valid Backup backup) {
		return backupDao.save(backup);
	}

}
