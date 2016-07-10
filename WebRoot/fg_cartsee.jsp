<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.GoodsForm"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>乐团</title>
  <link href="all.css" type="text/css" rel="stylesheet">

</head>
  <body >
  <div id="main" align="center">
  <div id="top">
  <jsp:include page="fg-top1.jsp" flush="true"/>
  <jsp:include page="fg-top2.jsp" flush="true"/></div>
  <div id="middle">
  <div id="left"><jsp:include page="cart_see.jsp" flush="true"/></div>
  <div id="right"><jsp:include page="fg_right.jsp" flush="true"/></div>
  <div id="clear"></div>
  </div>
  <div id="down"><jsp:include page="fg-down.jsp" flush="true"/></div>
  </div>
  
</body>
</html>
