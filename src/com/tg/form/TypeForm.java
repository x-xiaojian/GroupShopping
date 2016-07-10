package com.tg.form;

import org.apache.struts.action.ActionForm;

//会员表的bean
public class TypeForm extends ActionForm {
	private int typ_id=0; //城市ID

	private String typ_name=""; // 商品种类
	
	private String creat_time="";// 创建时间

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
	