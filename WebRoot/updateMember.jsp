<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.tools.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����</title>
</head>

<html>
<script language="javascript">
function checkEmpty(memberForm){
for(i=0;i<memberForm.length-2;i++){
if(memberForm.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
}
}
if(document.memberForm.password.value!=document.memberForm.passwordOne.value){
window.alert("��������������벻һ�£�����������");
return false;
}

}
</script>
<%@page import="com.tg.form.MemberForm"%>
<%MemberForm form=(MemberForm)session.getAttribute("memberform");%>
<body>
<form action="memberAction.do?action=7&id=<%=form.getId_member()%>"  method="post" enctype="multipart/form-data"  name="memberForm" onsubmit="return checkEmpty(memberForm)">
<table width="740" height="246" border="0" align="center">
  <tr>
<tr>
<td width="140"></td>
 <td >��Ա���ƣ�</td>
 <td><input  type="text" name="usename" value="<%=form.getUsename()%>"></td>
 <td width="140"></td>
</tr>

<tr>
<td width="140"></td>
 <td>Email��ַ��</td>
 <td><input name="email"  value="<%=form.getEmail()%>"></td> 
</tr>

<tr>
<td width="140"></td>
 <td>ԭ�������룺</td>
 <td> <input type="password" name="oldPassword"></td>
</tr>

<tr>
<td width="140"></td>
 <td>��Ա���룺</td>
 <td><input type="password" name="password" value=""></td>
</tr>

 <tr>
 <td width="140"></td>
 <td>����ȷ�ϣ�</td>
 <td><input type="password" name="passwordOne" value=""></td>
</tr>

<tr>
<td width="140"></td>
 <td>��ʵ������</td>
 <td><input  type="text" name="name" value="<%if(form.getName()==null){out.println("");}
          else{out.println(form.getName());}%>"></td>
</tr>

<tr>
<td width="140"></td>
 <td>�������£�</td>
 <td><input  type="text" name="birthdate" value="<%if(form.getBirthdate()==null){out.println("");}
          else{out.println(form.getBirthdate());}%>"></td>
</tr>

<tr>
<td width="140"></td>
 <td>�绰��</td>
 <td><input  type="text" name="tel" vvalue="<%if(form.getTel()==null){out.println("");}
          else{out.println(form.getTel());}%>"></td>
</tr>

<tr>
<td width="140"></td>
        <td height="35">�Ա�</td>
        <td>
          <select name="sex">
          <option value="1" >��</option>
          <option value="0">Ů</option>
          </select>
        </td> 
      </tr>

<tr>
<td width="140"></td>
        <td height="35">���ڳ��У�</td>
        <td><div align="center">
          <input type="hidden" name="area" value="<%=form.getArea()%>"><%=form.getArea()%>
        </div></td>
      </tr>
      
      
  <tr>    
<td width="140"></td>
 <td align="center">
<input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
<a href="#" onClick="javascript:memberForm.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
<a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
</td>
  </tr>

</table>
</form>
</body>
</html>
