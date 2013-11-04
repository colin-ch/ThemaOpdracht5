package com.appspot.Accent.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Id;

public class StageBedrijf implements Serializable{
	
	@Id Long id;
	private String username;
	private String password;
	private String email;
	private ArrayList<StageOpleider> opleiders = new ArrayList<StageOpleider>();
	private String plaats;
	private String code;
	
	public StageBedrijf(String us, String pw, String em, String place, String cd) {
		username = us;
		password =pw;
		email =em;
		plaats = place;
		code = cd;
		// TODO Auto-generated constructor stub
	}
	public StageBedrijf() {}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlaats() {
		return plaats;
	}
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


	public ArrayList<StageOpleider> getOpleiders() {
		return opleiders;
	}


	public void setOpleiders(ArrayList<StageOpleider> opleiders) {
		this.opleiders = opleiders;
	}

}
