<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*"%>
<%@ page import="com.tg.form.SellGoodsForm"%>
<%@ page import="com.tg.form.GoodsForm"%>
<%  
GoodsForm goodsform=(GoodsForm)request.getAttribute("goodsform");
int goodsID=Integer.parseInt(goodsform.getId_goods());
float goodsPrice=goodsform.getFreeprice(); 
SellGoodsForm sellGoodsForm=new SellGoodsForm();
sellGoodsForm.ID=goodsID;
sellGoodsForm.price=goodsPrice;
sellGoodsForm.number=1;
boolean flag=true;
Vector cart=(Vector)session.getAttribute("cart");
if(cart==null){
cart=new Vector();
}else{
for(int i=0;i<cart.size();i++){
   SellGoodsForm form1=(SellGoodsForm)cart.elementAt(i);
   if(form1.ID==sellGoodsForm.ID){
     form1.number++;
     cart.setElementAt(form1,i);
     flag=false;

   }
}
}
if(flag)
cart.add(sellGoodsForm);
session.setAttribute("cart",cart);

out.println("<script language='javascript'>alert('成功加入购物车!');javascript:history.back(-1);</script>");
%>
