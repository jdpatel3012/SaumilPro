package com.accounts.accountManager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.accountManager.model.Backup;
import com.accounts.accountManager.service.IBackupService;

@RestController
@CrossOrigin
@RequestMapping("/api/backup")
public class BackupController {

	@Autowired
	IBackupService iBackupService;

	@GetMapping
	public ResponseEntity<List<Backup>> fetchAllBackups() {
		List<Backup> backup = iBackupService.fetchAllBackups();
		return new ResponseEntity<List<Backup>>(backup, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Backup> saveBackup(@Valid @RequestBody Backup backup) {
		Backup backup2 = iBackupService.saveBackup(backup);
		return new ResponseEntity<Backup>(backup2, HttpStatus.OK);
	}
}
