<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.MemberForm"%>
<%@page import="com.tg.form.CityForm"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<link href="top_2.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
<!--
.STYLE2 {color: #0033CC}
.STYLE3 {font-size: 18px; color: #FFFFFF; }
.STYLE11 {color: #FFFFFF; font-family: "�����п�"; font-size: 18px;}
.STYLE12 {font-family: "�����п�"; }
-->
</style>
</head>
<script language="javascript">
function quit() {
  if(confirm("�����Ź���������")){
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
	<a href="index.jsp">�� ҳ</a></div></td>
    <td width="90" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12"><a href="fg_cityselect.jsp">����Ź�</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=1">��ʳ</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=2">�� Ӱ</a></div></td>
    <td width="50" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=3">ktv</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=4">�� ��</a></div></td> 
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=5">�� ��</a></div></td>
    <td width="250" bgcolor="#00CCFF" class="STYLE2"><div align="center"><span class="STYLE12"></span></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE11" ><a href="fg_login.jsp">�� ¼</a></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="fg_register.jsp">ע ��</a></span></div></td>
    <td width="70" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=shoppinglink%>">���ﳵ</a></span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3">������</span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=orderlink%>">�ҵ��Ź�</a></span></div></td>
  </tr>
</table>
<%}
else{ %>
	<table width="1000" height="33" border="0" align="center" bgcolor="#0099FF" back>
  <tr>
    <td width="60" height="29" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12"><a href="index.jsp">�� ҳ</a></div></td>
    <td width="90" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12"><a href="fg_cityselect.jsp">����Ź�</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=1">��ʳ</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=2">�� Ӱ</a></div></td>
    <td width="50" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=3">ktv</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=4">�� ��</a></div></td>
    <td width="60" bgcolor="#00CCFF" class="STYLE3"><div align="center" class="STYLE12">
	<a href="goodsAction.do?action=12&sortid=5">�� ��</a></div></td>
    <td width="250" bgcolor="#00CCFF" class="STYLE2"><div align="center"><span class="STYLE12"></span></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE11" ><font color="#FFFFFF"><%=form.getUsename()%></font></div></td>
    <td width="70" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=shoppinglink%>">���ﳵ</a></span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=memberlink%>">��Ա�޸�</a></span></div></td>
    <td width="90" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="<%=orderlink%>">�ҵ��Ź�</a></span></div></td>
    <td width="60" bgcolor="#00CCFF"><div align="center" class="STYLE12"><span class="STYLE3"><a href="javascript:quit()">�˳�</a></span></div></td>
  </tr>
</table>
<%}%>
</body>
</html>
