<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.tg.form.CityForm"%>
<%@page import="com.tg.form.MemberForm"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<body>
<table width="1000"  border="0" align="center" bordercolor="#FFFFFF" bgcolor="#333333">
  <tr>
    <td width="12%" height="88" rowspan="4" background="image/logo.jpg">&nbsp;</td>
    <td width="12%" height="45"  ></td>
    <td width="63%" rowspan="4">&nbsp;</td>
    <td rowspan="4" >&nbsp;</td>
  </tr>
  <tr>
  <%  if(session.getAttribute("cityform")==null) { 
  MemberForm memberform=(MemberForm)session.getAttribute("memberform"); 
%>
<td height="22"  align="center" ><font color="white">您的位置？</font></td>
 <td height="26" rowspan="2"  ></td>
  </tr>
  <tr>
    <td height="26"  ><a href="fg_cityselect.jsp">[选择城市]</a></td>
  </tr>
<%} else{
CityForm cityform=(CityForm)session.getAttribute("cityform");
%>
<td height="22"  align="center"><font color="white"><%=cityform.getCityName()%></font></td>
 <td height="54" rowspan="2"  ></td>
  </tr>
  <tr>
    <td height="26"  ><a href="fg_cityselect.jsp">[切换城市]</a></td>
  </tr>
<%} %>
</table>
</body>
</html>
