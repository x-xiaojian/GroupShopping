<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.GoodsForm"%>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*2;//开始条数
int over=(number+1)*2;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
  }
%>
 <script Language="JavaScript">
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <link href="goodsshow.css" type="text/css" rel="stylesheet">

</head>
  <body >
  <div id="main" align="center">
  <%for(int i=start;i<over;i++){
      GoodsForm form1=(GoodsForm)list.get(i);
          %>
  <div id="right1">
  <div id="picture">
  <a href="goodsAction.do?action=1&id=<%=form1.getId_goods()%>"><img  
   src="<%=form1.getGoods_image()%>" name="picture<%=i%>" width="100%" height="100%" border="0" align="left" ></a></div>
  <div id="name"><%=form1.getGoods_name()%></div>
  <div id="introduce"><%=form1.getIntroduce()%></div>
  <div id="price">
  <div id="priceleft">
  <font color="red" size="10px">￥<%=form1.getFreeprice()%></font>
  <s>门店价￥<%=form1.getPrice()%></s></div>
  <div id="priceright">
  <a href="goodsAction.do?action=1&id=<%=form1.getId_goods()%>">
  <img src="image/fg_top04.png"></a>
  </div>
  </div>
  <div id="num"><%=form1.getNumber()%>人已团购</div>
</div>
<%  i++;
if(i<over){
         GoodsForm form2=(GoodsForm)list.get(i);
          %>
  <div id="left1">
  <div id="picture">
  <td width="360"><a href="goodsAction.do?action=1&id=<%=form2.getId_goods()%>"><img  
   src="<%=form2.getGoods_image()%>" name="picture<%=i%>" width="100%" height="100%" border="0" align="right" ></a></td>
  </div>
  <div id="name"><%=form2.getGoods_name()%></div>
  <div id="introduce"><%=form2.getIntroduce()%></div>
  <div id="price">
 <div id="priceleft">
  <font color="red" size="8px">￥<%=form2.getFreeprice()%></font>
 <s> 门店价￥<%=form2.getPrice()%></s></div>
  <div id="priceright">
  <a href="goodsAction.do?action=1&id=<%=form2.getId_goods()%>">
  <img src="image/fg_top04.png"></a>
  </div>
  </div>
  <div id="num"><%=form2.getNumber()%>人已团购</div>
</div>
<%} 
else if(i>=over){%>
<div id="left1"></div>
<%} %>
<%} %>
<div id="page">
<table bgcolor="#E2F1F3" width="740"  border="0" align="center" cellpadding="0" cellspacing="0">
   <tr align="center">
    <td width="">共为<%=maxPage%>页</td>
			<td width="">共有<%=pageNumber%>条记录</td>
            <td width="">当前为第<%=number+1%>页</td>
    <td width=""><%if((number+1)==1){%> 上一页<%}else{%><a href="goodsAction.do?action=0&i=<%=number-1%>">上一页</a></td><%}%>
            <td width="" ><%if(maxPage<=(number+1)){%>下一页<%}else{%><a href="goodsAction.do?action=0&i=<%=number+1%>">下一页</a></td><%}%>
   </tr>
 </table>
 </div>
</div>
</body>
</html>
