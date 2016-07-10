package com.tg.web;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;

import org.apache.struts.action.Action;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.tg.form.ManagerForm;
import com.tg.dao.ManagerDao;
import java.util.*;


//��̨����Ա��Action
public class ManagerAction
    extends Action {
  private ManagerDao dao = null;
  private int action;
  private HttpSession session = null;
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {

    dao = new ManagerDao();
    action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
      case 0: {
        return managerCheck(mapping, form, request, response); //�жϹ���Ա��¼��̨
      }
      case 1: {
        return managerSelect(mapping, form, request, response); //��ѯ���еĹ���Ա��Ϣ
      }
      case 3: {
        return managerInsert(mapping, form, request, response); //��ӹ���Ա��Ϣ
      }
      case 4: {
        return managerDelete(mapping, form, request, response); //ɾ������Ա��Ϣ
      }
      case 5: {
        return managerUpdatePassword(mapping, form, request, response); //ת���޸������ҳ��
      }
    }
    throw new java.lang.UnsupportedOperationException(
        "Method $execute() not yet implemented.");
  }

//�޸Ĺ���Ա����
  public ActionForward managerUpdatePassword(ActionMapping mapping,
                                             ActionForm form,
                                             HttpServletRequest request,
                                             HttpServletResponse response) {
	    int id=Integer.parseInt(request.getParameter("id"));
	    String psw=request.getParameter("password").toString();
	    dao.updateManagerPassword(psw,id);
	    request.setAttribute("reslut", "�޸ĺ�̨����Ա����ɹ��������µ�¼������");
    return mapping.findForward("managerUpdatePassword");
  }






  //ɾ������Ա��Ϣ
  public ActionForward managerDelete(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    dao.deleteManager(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("reslut", "ɾ�����û����ɹ�������");
    return managerSelect(mapping,form,request,response);
  }

//��ӹ���Ա��Ϣ
  public ActionForward managerInsert(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    ManagerForm managerForm = (ManagerForm) form;
 
    ManagerForm manager = dao.selectOne(managerForm.getUsename());
    if (manager == null || manager.equals("")) {
       dao.insertManager(managerForm);
       return managerSelect(mapping,form,request,response);
    }else {
      request.setAttribute("reslut", "���û����Ѿ����ڣ�����");
      return mapping.findForward("managerInsert");
    }
  }



//��ѯ���еĹ���Ա��Ϣ
  public ActionForward managerSelect(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
    List list = dao.selectManager();
    int pageNumber = list.size(); //������ж�������¼
    int maxPage = pageNumber; //�����ж���ҳ��
    String number = request.getParameter("i");
    if (maxPage % 7 == 0) {
      maxPage = maxPage / 7;
    }
    else {
      maxPage = maxPage / 7 + 1;
    }
    if (number == null) {
      number = "0";
    }
    request.setAttribute("number", String.valueOf(number));
    request.setAttribute("maxPage", String.valueOf(maxPage));
    request.setAttribute("pageNumber", String.valueOf(pageNumber));

    request.setAttribute("list", list);
    return mapping.findForward("managerSelect");
  }

  //�жϹ���Ա��¼��̨
  public ActionForward managerCheck(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {
    String account =request.getParameter("account");
    ManagerForm managerForm= dao.selectOne(account);
    if (managerForm == null) {
      request.setAttribute("result", "��������˺Ų����ڣ�����");
      return mapping.findForward("checkResult");
    }
    else if (!managerForm.getPassword().equals(request.getParameter("password"))) {
      request.setAttribute("result", "����������벻���ڣ�����");
      return mapping.findForward("checkResult");
    } else {
      request.setAttribute("manager", managerForm);
      return mapping.findForward("checkResult");
    }
  }
}
