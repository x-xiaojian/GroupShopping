<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.CityForm"%>
<%@page import="com.tg.form.PromaryForm"%>
<%@page import="com.tg.form.GoodsForm"%>
<%@page import="com.tg.form.TypeForm"%>
<jsp:useBean id="goods" scope="page" class="com.tg.dao.GoodsDao"/>
<jsp:useBean id="promary" scope="page" class="com.tg.dao.PromaryDao"/>
<jsp:useBean id="city" scope="page" class="com.tg.dao.CityDao"/>
<jsp:useBean id="sort" scope="page" class="com.tg.dao.TypeDao"/>
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
List sortList=sort.selectType();
%>

<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
if(isNaN(document.form.nowPirce.value)){
window.alert("价格只能为数字");
return false;
}
}
function ChangeItem(){
var pro=form.aa.value;
window.location.href="goodsAction.do?action=2&proId="+pro;
}
</script>

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
    <td width="618" align="center" valign="top"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>添加商品信息</strong></div></td>
          </tr>
        </table>
        <br>

  <form action="goodsAction.do?action=3" method="post" enctype="multipart/form-data"  name="form" onSubmit="return checkEmpty(form)" >
        <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
          <tr>
            <td width="25%" height="26">&nbsp;省份</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;
              <select name="aa" Onchange="ChangeItem()">
              <%for(int i=0;i<proList.size();i++)
              {
              PromaryForm Form1=(PromaryForm)proList.get(i);
              %>
              <option  value="<%=Form1.getProID()%>" <%if(proId==Form1.getProID()){out.println("selected");}%>>
              <%=promary.selectName(Form1.getProID())%></option>
              <%} %>
              </select></td>
            <td width="20%">城市</td>
            <td width="31%" bgcolor="#FFFFFF">&nbsp;
              <select name="city">
              <%for(int j=0;j<cityList.size();j++){
              CityForm Form2=(CityForm)cityList.get(j);
              %>
              <option  value="<%=Form2.getCityName()%>" ><%= Form2.getCityName()%></option>
              <%} %>
              </select></td>
          </tr>
          <tr>
            <td height="25">商品名称</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="name" type="text" size="20"></td>
            <td>生产厂商</td>
            <td bgcolor="#FFFFFF">&nbsp;
            <input name="from" type="text" size="20"></td>
          </tr>
          
          <tr>
            <td height="27">商品定价</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="freePirce" type="text" size="20"></td>
            <td>初始化特价</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="nowPirce" type="text" size="20"></td>
          </tr>
		  
		  <tr>
            <td height="27">商品图片</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="formFile" type="file" id="formFile"></td>
             <td>商品种类</td>
            <td bgcolor="#FFFFFF">&nbsp;&nbsp;
             <select name="sort">
              <%for(int k=0;k<sortList.size();k++){
              TypeForm SortForm=(TypeForm)sortList.get(k);
              %>
              <option  value="<%=SortForm.getTyp_id()%>" ><%= SortForm.getTyp_name()%></option>
              <%} %>
              </select></td>
          </tr>
		  
		  
          <tr>
            <td height="28">&nbsp;&nbsp;简介</td>
            <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
            <input name="introduce" type="text" size="50"></td>
          </tr>
        </table><br>
     <input type="image" class="input1"  src="image/save.jpg" width="51" height="20">
&nbsp;&nbsp;
      <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
&nbsp;&nbsp;
      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
	  </form>
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />























</body>
</html>
