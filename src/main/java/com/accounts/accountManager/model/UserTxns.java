package com.accounts.accountManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "user_txns")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTxns implements Serializable {

	private static final long serialVersionUID = 2540811122295123265L;

	@Id
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "amt_cr")
	private float amtCr;

	@Column(name = "amt_dr")
	private float amtDr;

	@Column(name = "date", nullable = false)
	private String date;

	@Column(name = "note")
	private String note;

	@Lob
	@Column(name = "img")
	private byte[] img;

	@Column(name = "img_name")
	private String imgName;

	@Column(name = "img_type")
	private String imgType;

	@Column(name = "account_id", nullable = false)
	private String account_id;

	@Column(name = "category_id", nullable = false)
	private String category_id;

	@Column(name = "tag_id")
	private String tag_id;

	@Column(name = "txn_type_id", nullable = false)
	private String txn_type_id;

	@Column(name = "txn_id", nullable = false)
	private String txn_id;

	@Column(name = "exp", nullable = false)
	private int exp;

	public String getID() {
		return id;
	}

	public void setID(String iD) {
		id = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getAmtCr() {
		return amtCr;
	}

	public void setAmtCr(float amtCr) {
		this.amtCr = amtCr;
	}

	public float getAmtDr() {
		return amtDr;
	}

	public void setAmtDr(float amtDr) {
		this.amtDr = amtDr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public String getTxn_type_id() {
		return txn_type_id;
	}

	public void setTxn_type_id(String txn_type_id) {
		this.txn_type_id = txn_type_id;
	}

	public String getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

}
