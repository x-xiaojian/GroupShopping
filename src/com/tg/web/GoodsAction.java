package com.tg.web;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import com.tg.form.GoodsForm;

import org.apache.struts.action.Action;
import org.apache.struts.upload.FormFile;
import java.lang.Exception;

import com.tg.dao.GoodsDao;
import com.tg.form.CityForm;

import java.util.List;
import com.tg.tools.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoodsAction extends Action{
	private int action=0;
	private GoodsDao dao=null;
	private HttpSession session = null;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws  IOException  {		
		dao=new GoodsDao();
		this.action = Integer.parseInt(request.getParameter("action"));
		request.setCharacterEncoding("gb2312");
		session = request.getSession();
		switch (action) {
		case 0:{
			return selectFirst(mapping, form, request, response); // 首页显示所有商品
		}
		case 1:{
			return selectOneGoods(mapping, form, request, response); //查询商品详细信息
		}
		case 2:{
		    return selectCityName(mapping, form, request, response); // 查询城市的名称
		}
		case 3:{
				try {
					return saveGoods(mapping, form, request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //添加商品信息
		}
		case 4: {
			return selectFirstByCity(mapping, form, request, response); //商品后台查看
		}
		case 5: {
			return goodSelect(mapping, form, request, response); //商品后台查看
		}
		
		case 6: {
			return selectCity(mapping, form, request, response); // 查询城市的名称
		}
		case 7: {
			return getOneGoods(mapping, form, request, response); //获得当前商品
		}
		case 8:{
			return selectOneGoodsBehind(mapping, form, request, response); //查询商品详细信息
		}
		case 9: {
			return deleteGoods(mapping, form, request, response); // 删除商品信息
		}
		case 12: {
			return goodSelectTypeHead(mapping, form, request, response); // 按大类别商品信息查询商品和商品小类别的名称
		
		}
		}
		throw new java.lang.UnsupportedOperationException(
				"Method $execute() not yet implemented.");
		}
	
		
	
	
	//获得当前商品
	public ActionForward getOneGoods(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response){
		int id=Integer.parseInt(request.getParameter("id"));
		request.setAttribute("goodsform", dao.selectOneGoods(id));
		return mapping.findForward("getOneGoods");
	}
	
	// 全部查询信息
	public ActionForward goodSelect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List list = null;
		list = dao.selectGoods();
		int pageNumber = list.size(); // 计算出有多少条记录
		int maxPage = pageNumber; // 计算有多少页数
		String number = request.getParameter("i");
		if (maxPage % 6 == 0) {
			maxPage = maxPage / 6;
		} else {
			maxPage = maxPage / 6 + 1;
		}
		if (number == null) {
			number = "0";
		}
		request.setAttribute("number", String.valueOf(number));
		request.setAttribute("maxPage", String.valueOf(maxPage));
		request.setAttribute("pageNumber", String.valueOf(pageNumber));
		request.setAttribute("list", list);
		return mapping.findForward("goodSelect");
	}
	
	// 查询城市的名称
	public ActionForward selectCity(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("proId", request.getParameter("proId"));
		return mapping.findForward("citySelect");
	}
	
	
	
		// 按大类别商品信息查询商品和商品小类别的名称
		public ActionForward goodSelectTypeHead(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {
			List list=null;
			if(session.getAttribute("cityform")!=null){
				CityForm cityform=(CityForm)session.getAttribute("cityform");
			int type=Integer.parseInt(request.getParameter("sortid"));
			list=dao.selectType(type,cityform.getCityName()); 
			int pageNumber = list.size(); // 计算出有多少条记录
			int maxPage = pageNumber; // 计算有多少页数
			String number = request.getParameter("i");
			System.out.println("4");
			if (maxPage % 6 == 0) {
				maxPage = maxPage / 6;
			} else {
				maxPage = maxPage / 6 + 1;
			}
			if (number == null) {
				number = "0";
			}
			request.setAttribute("number", String.valueOf(number));
			request.setAttribute("maxPage", String.valueOf(maxPage));
			request.setAttribute("pageNumber", String.valueOf(pageNumber));
			request.setAttribute("list", list);
			return mapping.findForward("goodSelectTypeHead");
		  }
			else{
				int type=Integer.parseInt(request.getParameter("sortid"));
				list=dao.selectType(type,"北京市"); 
				int pageNumber = list.size(); // 计算出有多少条记录
				int maxPage = pageNumber; // 计算有多少页数
				String number = request.getParameter("i");
				System.out.println("4");
				if (maxPage % 6 == 0) {
					maxPage = maxPage / 6;
				} else {
					maxPage = maxPage / 6 + 1;
				}
				if (number == null) {
					number = "0";
				}
				request.setAttribute("number", String.valueOf(number));
				request.setAttribute("maxPage", String.valueOf(maxPage));
				request.setAttribute("pageNumber", String.valueOf(pageNumber));
				request.setAttribute("list", list);
				return mapping.findForward("goodSelectTypeHead");
			  }
			}
		// 首页显示所有商品
		public ActionForward selectFirst(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response){
			List list=null;
			if(session.getAttribute("cityform")!=null){
				CityForm cityform=(CityForm)session.getAttribute("cityform");
				  list=dao.selectGoodsByCity(cityform.getCityName()); 	
					int pageNumber = list.size(); // 计算出有多少条记录
					int maxPage = pageNumber; // 计算有多少页数
					String number = request.getParameter("i");
					if (maxPage %2 == 0) {
						maxPage = maxPage /2;
					} else {
						maxPage = maxPage / 2 + 1;
					}
					if (number == null) {
						number = "0";
					}
					request.setAttribute("number", String.valueOf(number));
					request.setAttribute("maxPage", String.valueOf(maxPage));
					request.setAttribute("pageNumber", String.valueOf(pageNumber));
					request.setAttribute("list", list);
					return mapping.findForward("selectFirst");
			}
			else{
			list=dao.selectFirst(); 
			int pageNumber = list.size(); // 计算出有多少条记录
			int maxPage = pageNumber; // 计算有多少页数
			String number = request.getParameter("i");
			System.out.println("4");
			if (maxPage % 6 == 0) {
				maxPage = maxPage / 6;
			} else {
				maxPage = maxPage / 6 + 1;
			}
			if (number == null) {
				number = "0";
			}
			request.setAttribute("number", String.valueOf(number));
			request.setAttribute("maxPage", String.valueOf(maxPage));
			request.setAttribute("pageNumber", String.valueOf(pageNumber));
			request.setAttribute("list", list);
			return mapping.findForward("selectFirst");
			}
		}
		
		
		 // 按城市显示所有商品
		public ActionForward selectFirstByCity(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response){
			List list=null;
			CityForm cityform=(CityForm)session.getAttribute("cityform");
			   list=dao.selectGoodsByCity(cityform.getCityName()); 
			   int pageNumber = list.size(); // 计算出有多少条记录
				int maxPage = pageNumber; // 计算有多少页数
				String number = request.getParameter("i");
				if (maxPage % 6 == 0) {
					maxPage = maxPage / 6;
				} else {
					maxPage = maxPage / 6 + 1;
				}
				if (number == null) {
					number = "0";
				}
				request.setAttribute("number", String.valueOf(number));
				request.setAttribute("maxPage", String.valueOf(maxPage));
				request.setAttribute("pageNumber", String.valueOf(pageNumber));
				request.setAttribute("list", list);
				return mapping.findForward("selectByCity");
				 
			}
			
		// 删除商品的操作
		public ActionForward deleteGoods(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) {
			dao.deleteGoods(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("result", "删除商品信息成功");
			return mapping.findForward("goodsOperation");
		}

		
		//查询商品详细信息
		public ActionForward selectOneGoods(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response){
			request.setAttribute("goodsform", dao.selectOneGoods(Integer.parseInt(request.getParameter("id"))));
			return mapping.findForward("selectOneGoods");
		}
	
		//后台查询商品详细信息
		public ActionForward selectOneGoodsBehind(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response){
			request.setAttribute("goodsform", dao.selectOneGoods(Integer.parseInt(request.getParameter("id"))));
			return mapping.findForward("selectContent");
		}
		
		// 查询城市的名称
		public ActionForward selectCityName(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) {
			request.setAttribute("proId", request.getParameter("proId"));
			return mapping.findForward("cityForward");
		}
		
		//添加商品信息
		public ActionForward saveGoods(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception{
			UploadFile uploadFile = new UploadFile();
			GoodsForm goodsForm = (GoodsForm) form;
			String dir = servlet.getServletContext().getRealPath("/image");
			FormFile formFile = goodsForm.getFormFile();
			String getType = formFile.getFileName().substring(
					formFile.getFileName().lastIndexOf(".") + 1);
			String result = "添加商品信息失败";
			String imageType[] = { "JPG", "jpg", "gif", "bmp", "BMP" ,"png"};
			for (int ii = 0; ii < imageType.length; ii++) {
				if (imageType[ii].equals(getType)) {
					
				    goodsForm.setArea(request.getParameter("city"));
				    goodsForm.setGoods_name(request.getParameter("name"));
				    goodsForm.setGoods_form(request.getParameter("from"));
				    goodsForm.setPrice(Float.parseFloat(request.getParameter("freePirce")));
				    goodsForm.setFreeprice(Float.parseFloat(request.getParameter("nowPirce")));
				    goodsForm.setIntroduce(request.getParameter("introduce"));
				    goodsForm.setSort(Integer.parseInt(request.getParameter("sort")));
					
					goodsForm.setGoods_image("image/"+uploadFile.upload(dir, formFile));
					dao.insertGoods(goodsForm);
					result = "添加商品信息成功";
				}
			}
			request.setAttribute("result", result);
		return mapping.findForward("goodsOperation");
		}
}