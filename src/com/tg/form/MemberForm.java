package com.tg.form;

import org.apache.struts.action.ActionForm;

//��Ա���bean
public class MemberForm extends ActionForm {
	private String email=""; // �����ʼ�

	private int id_member=-1; // ��Ա�Զ�����

	private String name=""; //  ��ʵ����

	private String usename=""; // ��Ա����
	
	private String password=""; // ��Ա����

	private String tel=""; // ��Ա�绰

	private String birthdate=""; // ��Ա����

	private boolean sex=true; // �Ա�

	private String area="" ; //����

	public MemberForm() {
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	public int getId_member() {
		return id_member;
	}

	public void setId_member(int id_mmber) {
		this.id_member = id_mmber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
	