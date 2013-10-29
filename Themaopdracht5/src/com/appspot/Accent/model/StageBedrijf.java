package com.appspot.Accent.model;

import java.util.ArrayList;

public class StageBedrijf extends User{
	private ArrayList<StageOpleider> opleiders = new ArrayList<StageOpleider>();
	private String plaats;
	private String code;
	
	public StageBedrijf(String us, String pw, String em, String place, String cd) {
		super(us, pw, em);
		plaats = place;
		code = cd;
		// TODO Auto-generated constructor stub
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

}
