package com.accounts.accountManager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.accountManager.model.Backup;

@Repository
public interface BackupDao extends CrudRepository<Backup,String>{

}
