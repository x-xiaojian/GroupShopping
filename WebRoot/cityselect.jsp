<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.CityForm"%>
<%@page import="com.tg.form.PromaryForm"%>
<jsp:useBean id="promary" scope="page" class="com.tg.dao.PromaryDao"/>
<jsp:useBean id="city" scope="page" class="com.tg.dao.CityDao"/>
<%
List proList=promary.selectPromary();			
%>




<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<body>
<table width="750" height="246" border="0" align="center">
  <tr>
  <tr>
 <td>
<%
for(int i=proList.size()-1;i>0;i--)
{
 PromaryForm Form1=(PromaryForm)proList.get(i);
 %>
 <tr>
 <td width="150" bgcolor="#999999"><%=Form1.getProName()%></td>
<%
int proId=Form1.getProID();
List cityList=city.selectOneProId(proId);
for(int j=0;j<cityList.size();j++){
  CityForm Form2=(CityForm)cityList.get(j);
 if((j+1)%5==0){%>
<tr>
<td width="150"></td>
<%}else{ %>
<td width="150"><a href="cityAction.do?action=0&cityID=<%=Form2.getCityID()%>&proID=<%=Form2.getProID()%>"><%=Form2.getCityName()%></a></td>
<%}%>
<% }%>
</tr>
<%} %>

</table>
</body>
</html>
