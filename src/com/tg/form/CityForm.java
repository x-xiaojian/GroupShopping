package com.tg.form;

import org.apache.struts.action.ActionForm;

//会员表的bean
public class CityForm extends ActionForm {
	
	private int cityID=0; //城市ID

	private String cityName; // 城市名称
	
	private int proID=0; // 省份ID

	public CityForm() {
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	

	

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}
	
	
}
	