package com.tg.form;

import org.apache.struts.action.ActionForm;

//会员表的bean
public class PromaryForm extends ActionForm {
	private int proID=0; //省份ID

	private String proName=""; // 省份名称

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
	