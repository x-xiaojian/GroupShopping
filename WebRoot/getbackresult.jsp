<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.tg.form.MemberForm"%>
<jsp:useBean id="dao" scope="page" class="com.tg.dao.MemberDao"/>
<%
request.setCharacterEncoding("GB2312");
MemberForm form=dao.selectMemberFormByName(request.getParameter("name"));%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>乐团</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<body>
<table width="745S" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td  align="center">&nbsp; 
<%if(form==null||form.equals("")){%>
 <p><strong>不存在此会员名称,请重新输入！！！</strong></p>
 <meta http-equiv="refresh" content="3;URL=fg-One.jsp">
  <%}else{%>
  <p><strong>已经将您的密码发送到您的邮箱请进行查收！</strong></p>
    <br>
 <meta http-equiv="refresh" content="3;URL=index.jsp">    
<%}%>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   </td>
  </tr>
</table>
</body>
</html>
