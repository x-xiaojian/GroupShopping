<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����</title>
<link href="left.css" type="text/css" rel="stylesheet"/>
</head>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
}
}
}
function quit() {
  if(confirm("û��Ҫ��Ķ�������")){
    window.location.href="loginOut.jsp";
	}
  }
</script>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.MemberForm"%>
<jsp:useBean id="countTime" scope="page" class="com.tg.tools.CountTime"/>
<body>
	
	<table width="750" height="138"  border="0" cellpadding="0" cellspacing="0" background="">
      <tr>
        <td valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
		 <tr>
            <td height="16">&nbsp;</td>
          </tr>
        </table>
        <form name="form" method="post" action="memberAction.do?action=1" onSubmit="return checkEmpty(form)">
          <table width="400" border="0" align="center">
            <tr>
              <td width="140" height="25">�û�����</td>
              <td width="200"> <input name="name" type="text" size="20"></td>
            </tr>
            <tr>
              <td height="25">��&nbsp;&nbsp;�룺</td>
              <td><input name="password" type="password" size="20"></td>
            </tr>
			 <tr>
              <td height="26"><input  type="submit"  value="��¼"  width="51" height="20"></td>
              <td height="26">  &nbsp;&nbsp;<a href="fg_register.jsp">ע��</a> <a href="fg-One.jsp">�һ����룿</a></td>
			 </tr>	
          </table>
		  </form>
		  </td>
      </tr>
    </table>	
			
      </table>













