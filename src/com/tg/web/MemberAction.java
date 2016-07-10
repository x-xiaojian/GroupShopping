package com.tg.web;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;

import com.tg.form.MemberForm;
import org.apache.struts.action.Action;


import com.tg.dao.MemberDao;
import java.io.IOException;
import java.util.*;



//��Ա����Action
public class MemberAction extends Action {
	private int action;
	private MemberDao dao = null;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		dao = new MemberDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		request.setCharacterEncoding("gb2312");
		switch (action) {
		case 0: {
			return insertMember(mapping, form, request, response); // ע���Ա��Ϣ
		}
		case 1: {
			return checkMember(mapping, form, request, response); // ��Ա��¼
		}
		case 2:{
			return selectMember(mapping, form, request, response);//�鿴��Ա��Ϣ
		}
		case 3:{
			return deleteMember(mapping, form, request, response);//ɾ����Ա��Ϣ
		}
		case 4:{
			return selectOneMember(mapping, form, request, response); // �鿴��Ա����ϸ��Ϣ
		}
		case 5: {
			return selectOneMemberHead(mapping, form, request, response); // ǰ̨��ѯ��Ա������
		}
		case 6: {
			return selectCityName(mapping, form, request, response); // ��ѯ���е�����
		}
		case 7: {
			return updateMemberHead(mapping, form, request, response); // �޸Ļ�Ա����
		}
		}
		//MemberForm memberForm = (MemberForm) form;
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
	}
	
	// �޸Ļ�Ա����
	public ActionForward updateMemberHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		MemberForm memberForm = (MemberForm) form;
		String email=request.getParameter("email");
		MemberForm formSelect=dao.selectMemberForm(email);
		String result = "�޸Ļ�Ա��Ϣʧ��,������������";
		System.out.println(result);
	    if ((request.getParameter("oldPassword").equals(formSelect.getPassword()))) {
	    	int id=-1;
	    	id=Integer.parseInt(request.getParameter("id"));
	    	System.out.println(id);
	    memberForm.setUsename(request.getParameter("usename"));	
		memberForm.setEmail(request.getParameter("email"));
		memberForm.setPassword(request.getParameter("password"));
		memberForm.setBirthdate(request.getParameter("birthdate"));	
		memberForm.setTel(request.getParameter("tel"));
		memberForm.setSex(Boolean.parseBoolean(request.getParameter("sex")));
		memberForm.setArea(request.getParameter("area"));
		memberForm.setId_member(id);
		System.out.println(request.getParameter("usename"));
		System.out.println(request.getParameter("area"));
		System.out.println(request.getParameter("birthdate"));
		System.out.println(request.getParameter("email"));
				dao.updateMember(memberForm);
				result = "���Ѿ��ɹ��޸���Ϣ";
			}
		request.setAttribute("result", result);
		return mapping.findForward("operationMember");
	}
	
	
	// ǰ̨��ѯ��Ա������
	public ActionForward selectOneMemberHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form", dao.selectOneMember(Integer.parseInt((request.getParameter("id")))));
		return mapping.findForward("selectOneMemberHead");
	} 
	
	//�鿴��Ա����ϸ��Ϣ
	public ActionForward selectOneMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		int id= Integer.parseInt(request.getParameter( "id" ));
		request.setAttribute("form", dao.selectOneMember(id));
		return mapping.findForward("selectOneMember");
	}
	
	
    //ɾ����Ա��Ϣ
	public ActionForward deleteMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
	   if (!dao.deleteMember(Integer.parseInt(request.getParameter("id")))) {
		   return mapping.findForward("deleteMember");
		}
		return selectMember(mapping,form,request,response);
	}

	
    //��ѯ���л�Ա
	public ActionForward selectMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		List list=dao.selectMember();            //����list���϶���
		int pageNumber=list.size();              //������ж�������¼
		int maxPage=pageNumber;                  //������ж���ҳ
		if(maxPage%6==0){                        //ÿһҳֻ��ʾ6����¼
			maxPage=maxPage/6;                   //�����Ļ�Ϊ�������
		}
		else{
			maxPage=maxPage/6+1;                 //����������1
		}
		String number = request.getParameter("i");
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		return mapping.findForward("selectMember");
	}

	// ��Ա��¼
	public ActionForward checkMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String name =request.getParameter("name");
		MemberForm memberForm = dao.selectMemberName(name);
		if (memberForm==null||memberForm.equals("")) {
			request.setAttribute("result", "�����ڴ˻�Ա�������µ�¼������");
		} else if (!memberForm.getPassword().equals(request.getParameter("password").trim())) {
			request.setAttribute("result", "������������µ�¼������");
		} else {	
			request.setAttribute("memberForm", memberForm);
		}
		return mapping.findForward("checkMember");
	}

	// ע���»�Ա
	
	public ActionForward insertMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		MemberForm memberForm = null;
		memberForm=new MemberForm();
		String email=request.getParameter("email");
		MemberForm formSelect=dao.selectMemberForm(email);
		String result = "ע���Աʧ��";
	    if (formSelect == null || formSelect.equals("")) {
	    memberForm.setUsename(request.getParameter("usename"));	
		memberForm.setArea(request.getParameter("city"));
		memberForm.setEmail(request.getParameter("email"));
		memberForm.setPassword(request.getParameter("password1"));
				dao.insertMember(memberForm);
				result = "���Ѿ��ɹ�ע��ɹ�";
			}
		request.setAttribute("result", result);
		return mapping.findForward("operationMember");
	}
	
	
	
	
	// ��ѯ���е�����
	public ActionForward selectCityName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("proId", request.getParameter("proId"));
		return mapping.findForward("cityForward");
	}
}
