<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>管理员登录</title>
<style type="text/css">
<!--
body {
	background-color: #f0f0f0;
}
-->
</style></head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
 <script language="javascript">
 function checkEmpty(){
 if(document.form.account.value==""){
  window.alert("请输入管理员账号")
   document.form.account.focus();
   return false;
 }
 if(document.form.password.value==""){
 window.alert("请输入管理员密码")
 document.form.password.focus();
 return false;
 }
 return true;
 } 
 
 </script>
<body> 
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
	
	
<form name="form" method="post" action="managerAction.do?action=0" onSubmit="return checkEmpty()">
<table width="548" height="294" border="0" align="center" cellpadding="0" cellspacing="0" background="image/bg-land.jpg">
  <tr>
    <td width="80"><br></td>
    <td width="456" valign="bottom" align="right"><table width="411" border="0">
      <tr>
        <td width="100" height="40"><div align="center"><font size="3" color="#9a6634"><strong>用户名：</strong></font></div>          </td>
        <td width="90"><font size="2"><input type="account" name="account" class="bgtext" size="10"></font></td>
        <td width="68"><font size="2">&nbsp;</font><font color="#9A6634" size="3"><strong>密码：</strong></font>          </td>
        <td width="90"><input name="password" type="password" class="bgtext" size="10"></td>
        <td width="50"><div align="right">
          <input name="Submit" type="image" class="bgButtoninput" src="image/bg-land.gif" >
        </div></td>
      </tr>
      <tr>
        <td height="30" colspan="5"><div align="right"><a href="index.jsp" class="a1">返回</a>&nbsp;&nbsp;</div></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
	
	
	
	
	
	</td>
  </tr>
</table>





</body>
</html>
