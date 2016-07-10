<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.tg.form.MemberForm"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>会员登录结果</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">

<body>
<p>&nbsp;</p>
<div align="center">
  <p><strong>
    <%if(request.getAttribute("result")==null){
        MemberForm memberform=(MemberForm)request.getAttribute("memberForm");
       session.setAttribute("memberform",memberform);
    %>
<meta http-equiv="refresh" content="0;URL=index.jsp">
  <%}else{%>
      <%
	  String result=(String)request.getAttribute("result");
	  %>
	  <script language='javascript'>alert('<%=result%>');window.location.href='fg_login.jsp';</script>

  <%}%> 
  </strong></p>
	
</div>
</body>
</html>
