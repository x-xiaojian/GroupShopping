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



//会员管理Action
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
			return insertMember(mapping, form, request, response); // 注册会员信息
		}
		case 1: {
			return checkMember(mapping, form, request, response); // 会员登录
		}
		case 2:{
			return selectMember(mapping, form, request, response);//查看会员信息
		}
		case 3:{
			return deleteMember(mapping, form, request, response);//删除会员信息
		}
		case 4:{
			return selectOneMember(mapping, form, request, response); // 查看会员的详细信息
		}
		case 5: {
			return selectOneMemberHead(mapping, form, request, response); // 前台查询会员的属性
		}
		case 6: {
			return selectCityName(mapping, form, request, response); // 查询城市的名称
		}
		case 7: {
			return updateMemberHead(mapping, form, request, response); // 修改会员属性
		}
		}
		//MemberForm memberForm = (MemberForm) form;
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
	}
	
	// 修改会员属性
	public ActionForward updateMemberHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		MemberForm memberForm = (MemberForm) form;
		String email=request.getParameter("email");
		MemberForm formSelect=dao.selectMemberForm(email);
		String result = "修改会员信息失败,您的密码有误";
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
				result = "你已经成功修改信息";
			}
		request.setAttribute("result", result);
		return mapping.findForward("operationMember");
	}
	
	
	// 前台查询会员的属性
	public ActionForward selectOneMemberHead(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("form", dao.selectOneMember(Integer.parseInt((request.getParameter("id")))));
		return mapping.findForward("selectOneMemberHead");
	} 
	
	//查看会员的详细信息
	public ActionForward selectOneMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		int id= Integer.parseInt(request.getParameter( "id" ));
		request.setAttribute("form", dao.selectOneMember(id));
		return mapping.findForward("selectOneMember");
	}
	
	
    //删除会员信息
	public ActionForward deleteMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
	   if (!dao.deleteMember(Integer.parseInt(request.getParameter("id")))) {
		   return mapping.findForward("deleteMember");
		}
		return selectMember(mapping,form,request,response);
	}

	
    //查询所有会员
	public ActionForward selectMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		List list=dao.selectMember();            //设置list集合对象
		int pageNumber=list.size();              //计算出有多少条记录
		int maxPage=pageNumber;                  //计算出有多少页
		if(maxPage%6==0){                        //每一页只显示6条记录
			maxPage=maxPage/6;                   //整除的话为整除结果
		}
		else{
			maxPage=maxPage/6+1;                 //不整除，加1
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

	// 会员登录
	public ActionForward checkMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String name =request.getParameter("name");
		MemberForm memberForm = dao.selectMemberName(name);
		if (memberForm==null||memberForm.equals("")) {
			request.setAttribute("result", "不存在此会员，请重新登录！！！");
		} else if (!memberForm.getPassword().equals(request.getParameter("password").trim())) {
			request.setAttribute("result", "密码错误，请重新登录！！！");
		} else {	
			request.setAttribute("memberForm", memberForm);
		}
		return mapping.findForward("checkMember");
	}

	// 注册新会员
	
	public ActionForward insertMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		MemberForm memberForm = null;
		memberForm=new MemberForm();
		String email=request.getParameter("email");
		MemberForm formSelect=dao.selectMemberForm(email);
		String result = "注册会员失败";
	    if (formSelect == null || formSelect.equals("")) {
	    memberForm.setUsename(request.getParameter("usename"));	
		memberForm.setArea(request.getParameter("city"));
		memberForm.setEmail(request.getParameter("email"));
		memberForm.setPassword(request.getParameter("password1"));
				dao.insertMember(memberForm);
				result = "你已经成功注册成功";
			}
		request.setAttribute("result", result);
		return mapping.findForward("operationMember");
	}
	
	
	
	
	// 查询城市的名称
	public ActionForward selectCityName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("proId", request.getParameter("proId"));
		return mapping.findForward("cityForward");
	}
}
