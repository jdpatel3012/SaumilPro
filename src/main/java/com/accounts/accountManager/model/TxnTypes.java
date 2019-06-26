package com.accounts.accountManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "txn_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TxnTypes implements Serializable{

	private static final long serialVersionUID = -6258501657041195331L;

	@Id
	@Column(name="id", nullable=false)
	private String ID;
	
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
