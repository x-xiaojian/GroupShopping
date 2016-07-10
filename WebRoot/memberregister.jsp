<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.CityForm"%>
<%@page import="com.tg.form.PromaryForm"%>
<jsp:useBean id="promary" scope="page" class="com.tg.dao.PromaryDao"/>
<jsp:useBean id="city" scope="page" class="com.tg.dao.CityDao"/>
<%
List proList=promary.selectPromary();
//List cityList=city.selectCity();
String id=(String)request.getAttribute("proId");
if(id==null||id.equals("")){			//当id值为空时，设置id值为-1
id="-1";					//当id值为空时，没有选择任何一个商品大类别名称，因此不会出现商品小类别名称
}
int proId=0;
proId=Integer.parseInt(id);
List cityList=city.selectOneProId(proId);
%>


<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
   }
}
//新加入的验证E-mail地址是否正确
var vemail=form.email.value;
var regExp=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
if(!regExp.test(vemail)){
	window.alert("您输入的邮箱地址不正确！");
	return false;
}
if(document.form.password1.value!=document.form.password2.value){
window.alert("您两次输入的密码不一致，请重新输入");
return false;
  }
 }
</script>


<script language="javascript">
function ChangeItem(){
var pro=form.pro.value;
window.location.href="memberAction.do?action=6&proId="+pro;
}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<body>
<form action="memberAction.do?action=0" method="post" enctype="multipart/form-data"  name="form" onSubmit="return checkEmpty(form)" >
<table width="740" height="246" border="0" align="center">
  <tr>
  <tr >
 <td>所在城市</td>
 <td>
 <select name="pro" Onchange="ChangeItem()">
<%for(int i=0;i<proList.size();i++)
{
 PromaryForm Form1=(PromaryForm)proList.get(i);
 %>
<option  value="<%=Form1.getProID()%>" <%if(proId==Form1.getProID()){out.println("selected");}%>>
<%=promary.selectName(Form1.getProID())%></option>
<%} %>
</select>

<select name="city">
<%for(int j=0;j<cityList.size();j++){
  CityForm Form2=(CityForm)cityList.get(j);
%>
<option  value="<%= Form2.getCityName()%>" ><%= Form2.getCityName()%></option>
<%} %>
</select>
 </td>
  </tr>

<tr>
 <td>邮箱</td>
 <td><input  type="text" name="email" /></td>
</tr>

<tr>
 <td>用户名</td>
 <td><input  type="text" name="usename" /></td>
</tr>

<tr>
 <td>创建密码</td>
 <td><input name="password1" type="password"/></td>
</tr>

<tr>
 <td>确认密码</td>
 <td><input type="password" name="password2" value=""/></td>
</tr>

 
  <tr>
 <td></td>
 <td>
 <input name="agree" type="checkbox" value="1"/>订阅每日最新团购信息，可随时退订
 </td>
 </tr>
 
 <tr>
 <td></td>
 <td>
 <input type="submit" value="同意以下协议并注册"/>
 </td>
 </tr>
 
 <tr>
 <td></td>
 <td>
 <a href="http://www.meituan.com/about/terms" target="_blank" class="terms">《乐团网用户协议》</a>
 </td>
 </tr>
  

</table>
  </form>
</body>
</html>
