<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.MemberForm"%>
<%@page import="com.tg.form.CityForm" %>
<%@page import="com.tg.form.PromaryForm"%>
<jsp:useBean id="promary" scope="page" class="com.tg.dao.PromaryDao"/>
<jsp:useBean id="city" scope="page" class="com.tg.dao.CityDao"/>
<%
List proList=promary.selectPromary();
String id=(String)request.getAttribute("proId");
if(id==null||id.equals("")){
id="-1";}
int proId=Integer.parseInt(id);
List cityList=city.selectOneProId(proId);
%>
<script language="javascript">
function ChangeItem(){
var pro=form.aa.value;
window.location.href="memberAction.do?action=6&proId="+pro;
}

</script>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert(form.elements[i].name+"表单信息不能为空");
return false;
  }
if(form.agree.checked=true){
alert(form.elements[i].name+"表单信息不能为空");
 }
}

</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>会员信息查询</title>
<style type="text/css">
<!--
body {
	background-color:#E2F1F3;
}
-->
</head>
<body>
<form name="form" method="post" action="memberAction.do?action=2" onSubmit="return checkEmpty(form)">
<input type="submit" value="会员信息查询">
<select name="aa" Onchange="ChangeItem()">
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
<option  value="<%=Form2.getCityID()%>" ><%= Form2.getCityName()%></option>
<%} %>
</select>

</form>
</body>
<input type=radio name="r1" onclick="f1()"><input type=radio name="r1" onclick="f1()">
<select name="s1" onchange="alert('selected :'+this.value)">
<option>请选</option>
<option value="1">男</option>
<option value="2">女</option>
</select>
<script>
alert("radio1 value is :"+document.all("r1")[0].value)
function f1(){
 for(var i=0;i<document.all("r1").length;i++){
  if(document.all("r1")[i].checked){alert(i+"被选中了")}
 }
}
</script>
      </table>

<table>
<tr align="center"  bgcolor="#00FFFF">
        <td width="117" height="31" onMouseOver="#00CCFF" onMouseOut="#00FFFF"><a href="index.jsp" class="a4">首页</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="bg-resultTen.jsp" class="a4">销售排行</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="goodsAction.do?action=14&mark=0" class="a4">新品上架</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="goodsAction.do?action=15&mark=1" class="a4">特价商品</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="11" class="a4">查看订单</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="11" class="a4">购物车</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="11" class="a4">会员修改</a></td>
        <td width="117" onMouseOver="this.style.backgroundImage='url(image/fg_top04.jpg)'" onMouseOut="this.style.backgroundImage=''"><a href="#" onclick="this.style.behavior='url(#default#homepage)';this.sethomepage('http://www.mingrisoft.com')" class="a4">设为首页</a></td>
      </tr>	
</table>











