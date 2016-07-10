<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.GoodsForm"%>
<%@ page import="com.tg.form.MemberForm"%>
<%
GoodsForm goodsform=(GoodsForm)request.getAttribute("goodsform");  
MemberForm form=null;
 String  cartlink="connection.jsp";
 if(session.getAttribute("memberform")!=null){
  form=(MemberForm)session.getAttribute("memberform");
  cartlink="goodsAction.do?action=7&id="+goodsform.getId_goods();
  }%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>商品详情</title>
<link type="text/css" href="OneGoods.css" rel="stylesheet">
</head>
<body>
<div id="main">
<div id="name"><%=goodsform.getGoods_name()%></div>
<div id="introduce"><%=goodsform.getIntroduce()%></div>
<div id="middle">
<div id="left">
<div id="price"><font color="red" size="10px">￥<%=goodsform.getFreeprice()%></font>
 <s>门店价￥<%=goodsform.getPrice()%></s></div>
<div id="num"><%=goodsform.getNumber()%>人已团购</div>
<div id="num"><a href="<%=cartlink%>">
  <img src="image/fg_buy2.png"></a></div>
<div id="buy"><img src="image/fg_buy1.png"></div>
</div>
<div id="image"><img  src="<%=goodsform.getGoods_image()%>"  width="100%" height="100%" border="0" align="right" ></div>
</div>
<div id="detail">
<div id="td">本单详情</div>
<div id="td">商家简介</div>
<div id="td"></div>
<div id="text"></div>
</div>
</div>
</body>
</html>
