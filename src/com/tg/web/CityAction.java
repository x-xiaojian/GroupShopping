package com.tg.web;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForward;
import com.tg.form.CityForm;
import org.apache.struts.action.Action;

import com.tg.dao.CityDao;
import java.io.IOException;

public class CityAction extends Action {
	private int action = 0;
	private CityDao dao = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		dao = new CityDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		request.setCharacterEncoding("gb2312");
		switch (action) {
		case 0: {
			return getCity(mapping, form, request, response); // 获得城市的名称
		}
		}
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
	}

	// 获得城市名称

	public ActionForward getCity(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int city = Integer.parseInt(request.getParameter("cityID"));
		int pro = Integer.parseInt(request.getParameter("proID"));
		CityForm cityform = dao.selectOneCity(city, pro);
		HttpSession session = request.getSession();
		session.setAttribute("cityform", cityform);
		return mapping.findForward("cityselect");
	}

}