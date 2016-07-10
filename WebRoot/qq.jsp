<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%java.util.Date date=new java.util.Date();%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <input type="submit" class="s-submit" hidefocus="true" value="搜索">
    <title>My JSP 'qq.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
   <form action="qq.jsp" method="post">
    name:<input type="text" name="w" autocomplete="off" class="s-text" 
    value="" x-webkit-speech="" placeholder="请输入商品名称、地址等" id="yui_3_8_0_1_1368368064287_42">
    <input type="submit" class="s-submit" hidefocus="true" value="搜索">
    
		<br>
		<input type="submit" value="测试">
		</form>
		<%String name =request.getParameter("name");
		System.out.println(name+"qqqqq"); %>
  </body>
  <input type=radio name="r1" onclick="f1()"><input type=radio name="r1" onclick="f1()">
<select name="s1" onchange="alert('selected :'+this.value)">
<td><%=date.getTime()%></td>
<option>请选</option>
<option value="1">男</option>
<option value="2">女</option>
</select>
<script>
function f1(){
 for(var i=0;i<document.all("r1").length;i++){
  if(document.all("r1")[i].checked){alert(i+"被选中了")}
 }
}
</script>
 
</html>
