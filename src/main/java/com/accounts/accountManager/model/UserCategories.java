package com.accounts.accountManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "user_categories")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCategories implements Serializable{

	private static final long serialVersionUID = -5255073680084259388L;

	@Id
	@Column(name="id", nullable=false)
	private String ID;
	
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@Column(name="cat_icon", nullable=false)
	private String catIcon;
	
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
	public String getCatIcon() {
		return catIcon;
	}
	public void setCatIcon(String catIcon) {
		this.catIcon = catIcon;
	}
	
}
