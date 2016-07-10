<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*"%>
<%
session.removeAttribute("cart");
response.sendRedirect("fg_cartsee.jsp");
%>
