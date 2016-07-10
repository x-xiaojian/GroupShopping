<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.MemberForm"%>
<%@page import="com.tg.form.CityForm"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="top_2.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
<!--
.STYLE2 {color: #0033CC}
.STYLE3 {font-size: 18px; color: #FFFFFF; }
.STYLE11 {color: #FFFFFF; font-family: "华文行楷"; font-size: 18px;}
.STYLE12 {font-family: "华文行楷"; }
-->
</style>
</head>
<script language="javascript">
function quit() {
  if(confirm("您的团购结束了吗？")){
    window.location.href="loginOut.jsp";
	}
  }
</script>
<%
  String memberlink="connection.jsp";
  String orderlink="connection.jsp";
  String shoppinglink="connection.jsp";
  MemberForm form=null;
  if(session.getAttribute("memberform")!=null){
  form=(MemberForm)session.getAttribute("memberform");
  memberlink="memberAction.do?action=5&id="+form.getId_member();
  orderlink="fg_cartdetail.jsp";
  shoppinglink="fg_cartsee.jsp";
  }
%>
<jsp:useBean id="countTime" scope="page" class="com.tg.tools.CountTime"/>
<body>
<%if(session.getAttribute("memberform")==null){
	%>		
<table width="1000" height="33" border="0" align="center" bgcolor="#0099FF" back>
  <tr>
    <td width="60" height="33" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="index.jsp">首 页</a></div></td>
    <td width="90" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12"><a href="fg_cityselect.jsp">身边团购</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=1">美食</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=2">电 影</a></div></td>
    <td width="50" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=3">ktv</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=4">酒 店</a></div></td> 
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=5">购 物</a></div></td>
    <td width="250" bgcolor="#00CCFF" class="STYLE2"><div align="center"><span class="STYLE12"></span></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE11" ><a href="fg_login.jsp">登 录</a></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="fg_register.jsp">注 册</a></span></div></td>
    <td width="70" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=shoppinglink%>">购物车</a></span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3">最近浏览</span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=orderlink%>">我的团购</a></span></div></td>
  </tr>
</table>
<%}
else{ %>
	<table width="1000" height="33" border="0" align="center" bgcolor="#0099FF" back>
  <tr>
    <td width="60" height="29" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12"><a href="index.jsp">首 页</a></div></td>
    <td width="90" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12"><a href="fg_cityselect.jsp">身边团购</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=1">美食</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=2">电 影</a></div></td>
    <td width="50" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=3">ktv</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=4">酒 店</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=5">购 物</a></div></td>
    <td width="250" bgcolor="#00CCFF" class="STYLE2"><div align="center"><span class="STYLE12"></span></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE11" ><font color="#FFFFFF"><%=form.getUsename()%></font></div></td>
    <td width="70" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=shoppinglink%>">购物车</a></span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=memberlink%>">会员修改</a></span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=orderlink%>">我的团购</a></span></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="javascript:quit()">退出</a></span></div></td>
  </tr>
</table>
<%}%>
</body>
</html>
