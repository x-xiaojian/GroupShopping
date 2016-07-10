package com.tg.form;

import org.apache.struts.action.ActionForm;

//会员表的bean
public class MemberForm extends ActionForm {
	private String email=""; // 电子邮件

	private int id_member=-1; // 会员自动编码

	private String name=""; //  真实姓名

	private String usename=""; // 会员名称
	
	private String password=""; // 会员密码

	private String tel=""; // 会员电话

	private String birthdate=""; // 会员生日

	private boolean sex=true; // 性别

	private String area="" ; //地区

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
	