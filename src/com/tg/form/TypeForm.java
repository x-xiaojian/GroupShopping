package com.tg.form;

import org.apache.struts.action.ActionForm;

//��Ա���bean
public class TypeForm extends ActionForm {
	private int typ_id=0; //����ID

	private String typ_name=""; // ��Ʒ����
	
	private String creat_time="";// ����ʱ��

	public TypeForm() {
	}

	public int getTyp_id() {
		return typ_id;
	}

	public void setTyp_id(int typ_id) {
		this.typ_id = typ_id;
	}

	public String getTyp_name() {
		return typ_name;
	}

	public void setTyp_name(String typ_name) {
		this.typ_name = typ_name;
	}

	public String getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(String creat_time) {
		this.creat_time = creat_time;
	}

	
	
}
	