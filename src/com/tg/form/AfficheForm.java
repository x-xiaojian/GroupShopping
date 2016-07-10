package com.tg.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

//公告信息bean
public class AfficheForm
    extends ActionForm {
	
  private String content = "";
  private int id_affiche = -1;
  private String creat_time = "";
  private String affiche_name ="";
  public AfficheForm() {}
  public String getContent() {
    return content;
  }

 
public int getId_affiche() {
	return id_affiche;
}
public void setId_affiche(int id_affiche) {
	this.id_affiche = id_affiche;
}
public String getCreat_time() {
	return creat_time;
}
public void setCreat_time(String creat_time) {
	this.creat_time = creat_time;
}
public String getAffiche_name() {
	return affiche_name;
}
public void setAffiche_name(String affiche_name) {
	this.affiche_name = affiche_name;
}
public void setContent(String content) {
	this.content = content;
}
public ActionErrors validate(ActionMapping actionMapping,
                               HttpServletRequest httpServletRequest) {
    /** @todo: finish this method, this is just the skeleton.*/
    return null;
  }

  public void reset(ActionMapping actionMapping,
                    HttpServletRequest servletRequest) {
  }
}
