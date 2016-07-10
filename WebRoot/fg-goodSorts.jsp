<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.TypeForm"%>
<jsp:useBean id="sort" scope="page" class="com.tg.dao.TypeDao"/>
<%List sortList=(List)sort.selectType();%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<table  height="25"  border="0" cellpadding="0" cellspacing="0" align="center">
   <tr>
     <td  align="center">
     <%for(int i=0;i<sortList.size();i++){
       TypeForm sortForm=(TypeForm)sortList.get(i);
     %>
     <a href="goodsAction.do?action=12&big=<%=sortForm.getTyp_id()%>"><%=sortForm.getTyp_name()%></a>&nbsp;&nbsp;
     <%}%>
	 </td>
   </tr>
</table>
