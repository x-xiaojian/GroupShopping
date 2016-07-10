package com.tg.form;


import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;
//π‹¿Ì‘±bean
public class ManagerForm
    extends ActionForm {

	private	int id_manager=1;
    private	String name="";
    private	String  usename="";
    private String	password="";
    private int	sign=-1;	


  public ManagerForm(){}


  

 



public int getId_manager() {
	return id_manager;
}








public void setId_manager(int id_manager) {
	this.id_manager = id_manager;
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








public int getSign() {
	return sign;
}








public void setSign(int sign) {
	this.sign = sign;
}








public ActionErrors validate(ActionMapping actionMapping,
                               HttpServletRequest httpServletRequest) {
     return null;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest servletRequest) {
  }
}
