<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.tg.form.MemberForm"%>
<jsp:useBean id="dao" scope="page" class="com.tg.dao.MemberDao"/>
<%
request.setCharacterEncoding("GB2312");
MemberForm form=dao.selectMemberFormByName(request.getParameter("name"));%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<body>
<table width="745S" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td  align="center">&nbsp; 
<%if(form==null||form.equals("")){%>
 <p><strong>�����ڴ˻�Ա����,���������룡����</strong></p>
 <meta http-equiv="refresh" content="3;URL=fg-One.jsp">
  <%}else{%>
  <p><strong>�Ѿ����������뷢�͵�������������в��գ�</strong></p>
    <br>
 <meta http-equiv="refresh" content="3;URL=index.jsp">    
<%}%>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   </td>
  </tr>
</table>
</body>
</html>
