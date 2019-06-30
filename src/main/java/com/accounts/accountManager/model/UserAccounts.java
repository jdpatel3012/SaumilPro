package com.accounts.accountManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "user_accounts")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccounts implements Serializable {

	private static final long serialVersionUID = -1436968572196169646L;

	@Id
	@Column(name = "id", nullable = false)
	private String ID;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "acc_no", nullable = false)
	private String acc_no;

	@Column(name = "balance")
	private float balance;

	@Column(name = "active", nullable = false)
	private int active;

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}

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

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
}
