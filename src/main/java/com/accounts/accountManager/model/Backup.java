package com.accounts.accountManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "backup_master")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Backup implements Serializable{

	private static final long serialVersionUID = 4194344153763893090L;

	@Id
	@Column(name="id", nullable=false)
	private String ID;
	
	@Column(name="date", nullable=false)
	private String Date;
	
	@Column(name="location", nullable=false)
	private String location;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
