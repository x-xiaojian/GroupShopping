package com.tg.form;

import org.apache.struts.action.ActionForm;

//��Ա���bean
public class CityForm extends ActionForm {
	
	private int cityID=0; //����ID

	private String cityName; // ��������
	
	private int proID=0; // ʡ��ID

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
	