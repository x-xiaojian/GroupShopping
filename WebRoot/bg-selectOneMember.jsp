/<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.MemberForm"%>


<%
MemberForm form=(MemberForm)request.getAttribute("form");
String sex=null;
System.out.println(String.valueOf(form.getSex())+"1");
if(form.getSex()==true)
sex="女";
else if(form.getSex()==false)
sex="男";
else if(String.valueOf(form.getSex())==null||String.valueOf(form.getSex()).equals(""))
sex="保密";
            
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>乐团的后台</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>查看会员的详细情况</strong></div></td>
          </tr>
        </table>
        <br>

 <table width="85%" height="130" cellspacing="1" cellpadding="1" bordercolor="#ffffff" border="1" bgcolor="#cccccc"> 
          <tr></tr></table><ul><li><br></li></ul><table width="71%" height="130" cellspacing="1" cellpadding="1" bordercolor="#ffffff" border="1" bgcolor="#cccccc"><tr> 
            <td width="22%" height="26" align="center">邮&nbsp;&nbsp; 箱<br></td> 
            <td width="31%" bgcolor="#ffffff"><div align="center"><%=form.getEmail()%></div></td> 
            <td width="20%"><div align="center">会员编号</div></td> 
            <td width="31%" bgcolor="#ffffff"><div align="center"><%=form.getId_member()%></div></td> 
          </tr> 
          <tr> 
            <td height="25"><div align="center">会员姓名</div></td> 
            <td bgcolor="#ffffff"><div align="center"><%=form.getName()%></div></td> 
            <td><div align="center">会员用户名</div></td> 
            <td bgcolor="#ffffff"><div align="center"><%=form.getUsename()%></div></td> 
          </tr> 
          <tr> 
            <td height="27"><div align="center">会员电话</div></td> 
            <td bgcolor="#ffffff"><div align="center"><%=form.getTel()%></div></td> 
            <td><div align="center">会员生日</div></td> 
            <td bgcolor="#ffffff"><div align="center"><%=form.getBirthdate()%></div></td> 
          </tr> 
 
          <tr> 
           <td height="27"><div align="center">性&nbsp; 别</div></td> 
            <td bgcolor="#ffffff"><div align="center"><%=sex%></div></td> 
            <td><div align="center">地&nbsp;&nbsp; 区<br></div></td> 
            <td bgcolor="#ffffff"><div align="center"><%=form.getArea()%></div></td> 
          </tr> 
      </table>
        <table width="71%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="87%" height="29">&nbsp;</td>
            <td width="13%"> <a href="javascript:history.back();">返回</a></td>
          </tr>
        </table>





		
</table>	






<jsp:include page="bg-down.jsp" flush="true" />


</body>
</html>
