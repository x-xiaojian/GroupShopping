<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.tg.form.OrderDetailForm"%>
<%@ page import="com.tg.form.OrderForm"%>
<%@ page import="com.tg.form.GoodsForm"%>
<%@ page import="com.tg.form.SellGoodsForm"%>
<jsp:useBean id="goodsDao" scope="page" class="com.tg.dao.GoodsDao"/>
<jsp:useBean id="orderDao" scope="page" class="com.tg.dao.OrderDao"/>
<jsp:useBean id="orderDetailDao" scope="page" class="com.tg.dao.OrderDetailDao"/>
<%
request.setCharacterEncoding("gb2312");
OrderForm order=new OrderForm();
OrderDetailForm orderDetail=new OrderDetailForm();
SellGoodsForm sellGoodsForm=new SellGoodsForm();
String number=request.getParameter("number").trim();
//先添加订单表
order.setNumber(number);
order.setName(request.getParameter("usename"));
order.setReallyName(request.getParameter("name"));
order.setAddress(request.getParameter("address"));
order.setTel(request.getParameter("tel"));
order.setSetMoney(request.getParameter("setMoney"));
order.setPost(request.getParameter("post"));
order.setBz(request.getParameter("bz"));
order.setSign("0");
orderDao.insertOrderDetail(order);

//然后添加商品的明仔细表
Vector cart=(Vector)session.getAttribute("cart");
for(int i=0;i<cart.size();i++){
  SellGoodsForm form=(SellGoodsForm)cart.elementAt(i);
 orderDetail.setOrderNumber(number); 
 orderDetail.setGoodsId(form.ID);
 orderDetail.setPrice(form.price);
 orderDetail.setNumber(form.number);
 goodsDao.updateGoodsNumber(form.number,new Integer(form.ID));
 orderDetailDao.insertOrderDetail(orderDetail);
}
out.println("<script language='javascript'>alert('请记住订单编号');window.location.href='cart_clear.jsp';</script>");
%>
