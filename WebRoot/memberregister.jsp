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
if(id==null||id.equals("")){			//��idֵΪ��ʱ������idֵΪ-1
id="-1";					//��idֵΪ��ʱ��û��ѡ���κ�һ����Ʒ��������ƣ���˲��������ƷС�������
}
int proId=0;
proId=Integer.parseInt(id);
List cityList=city.selectOneProId(proId);
%>


<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
   }
}
//�¼������֤E-mail��ַ�Ƿ���ȷ
var vemail=form.email.value;
var regExp=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
if(!regExp.test(vemail)){
	window.alert("������������ַ����ȷ��");
	return false;
}
if(document.form.password1.value!=document.form.password2.value){
window.alert("��������������벻һ�£�����������");
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
<title>�ޱ����ĵ�</title>
</head>
<body>
<form action="memberAction.do?action=0" method="post" enctype="multipart/form-data"  name="form" onSubmit="return checkEmpty(form)" >
<table width="740" height="246" border="0" align="center">
  <tr>
  <tr >
 <td>���ڳ���</td>
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
 <td>����</td>
 <td><input  type="text" name="email" /></td>
</tr>

<tr>
 <td>�û���</td>
 <td><input  type="text" name="usename" /></td>
</tr>

<tr>
 <td>��������</td>
 <td><input name="password1" type="password"/></td>
</tr>

<tr>
 <td>ȷ������</td>
 <td><input type="password" name="password2" value=""/></td>
</tr>

 
  <tr>
 <td></td>
 <td>
 <input name="agree" type="checkbox" value="1"/>����ÿ�������Ź���Ϣ������ʱ�˶�
 </td>
 </tr>
 
 <tr>
 <td></td>
 <td>
 <input type="submit" value="ͬ������Э�鲢ע��"/>
 </td>
 </tr>
 
 <tr>
 <td></td>
 <td>
 <a href="http://www.meituan.com/about/terms" target="_blank" class="terms">���������û�Э�顷</a>
 </td>
 </tr>
  

</table>
  </form>
</body>
</html>
