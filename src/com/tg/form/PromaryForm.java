package com.tg.form;

import org.apache.struts.action.ActionForm;

//��Ա���bean
public class PromaryForm extends ActionForm {
	private int proID=0; //ʡ��ID

	private String proName=""; // ʡ������

	public PromaryForm() {
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	
	
}
	