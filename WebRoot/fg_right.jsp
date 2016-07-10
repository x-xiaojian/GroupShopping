<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
</head>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.tg.form.AfficheForm"%>
<%@page import="com.tg.form.GoodsForm"%>
<%@page import="com.tg.form.MemberForm"%>
<%@page import="com.tg.form.LinkForm"%>
<jsp:useBean id="affiche" scope="page" class="com.tg.dao.AfficheDao"/>
<jsp:useBean id="goods" scope="page" class="com.tg.dao.GoodsDao"/>
<jsp:useBean id="linkdao" scope="page" class="com.tg.dao.LinkDao"/>
<jsp:useBean id="countTime" scope="page" class="com.tg.tools.CountTime"/>
<%List afficheList=(List)affiche.selectAffiche();%>
<body>
<!--左侧01-->
	
	<!--左侧02-->		
        <table width="100%" height="194" border="0" background="image/fg_left02.jpg">
          <tr>
            <td valign="top"><table width="150" border="0">
              <tr>
                <td height="32">&nbsp;</td>
              </tr>
            </table>
              <table width="220" border="0" align="center">
                <tr>
                  <td width="220" height="143">
				  <marquee direction="up" height="114" onmouseout="this.start()" 
             onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">	  
		            <%
                      for(int i=0;i<afficheList.size();i++){
                        AfficheForm afficheForm=(AfficheForm)afficheList.get(i);
                        %>
						<img src="image/sign.gif">&nbsp;
	<a href="#" onClick="window.open('fg-afficheSelect.jsp?id=<%=afficheForm.getId_affiche()%>','','width=500,height=400');">					
						<%=afficheForm.getAffiche_name()%></a><br><br>
						<%}%>
            </marquee>			      </td>
                </tr>
              </table></td>
          </tr>
        </table>	
	    <table width="100%" height="193" border="0" cellpadding="0" cellspacing="0" background="image/fg_left03.jpg">
          <tr>
            <td valign="top"><table width="194" border="0">
              <tr>
                <td height="40">&nbsp;</td>
              </tr>
            </table>          
			
			            <%
             List goodsList =goods.selectGoodsNumber();
             int number=goodsList.size();
           if(number>7){
             number=7;
           }
             for(int account=0;account<number;account++){
             GoodsForm form=(GoodsForm)goodsList.get(account);
             %>			
			  <table width="220" height="19" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_left04.jpg">
			    <tr>
			    <td width="14"></td>
                <td width="220"><a href="goodsAction.do?action=1&id=<%=form.getId_goods()%>"><font size="3px"><%=account+1%>&nbsp;&nbsp;<%=form.getGoods_name()%></font></a></td>
				</tr>   
            </table>				
			<%}%>	</td>
          </tr>
        </table>
	    <table width="100%" height="181" border="0" cellpadding="0" cellspacing="0" background="image/fg_left05.jpg">
          <tr>
            <td valign="top"><table width="173">
              <tr>
                <td height="35">&nbsp;</td>
              </tr>
            </table>
              <table width="240" align="center">
                <tr>
                  <td height="38" >
				  <MARQUEE direction="up" height="114" onmouseout="this.start()" 
             onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">	  
		            <%
		              List linkList=(List)linkdao.selectLink();
                      for(int i=0;i<linkList.size();i++){
                      LinkForm linkForm=(LinkForm)linkList.get(i);
                      %>
					&nbsp;&nbsp;<img src="image/sign1.gif">&nbsp; <a href="<%=linkForm.getLinkAddress()%>" target="_blank"><%=linkForm.getLinkName()%></a><br><br>
					<%}%>
            </marquee>				 </td>
                </tr>
              </table></td>
          </tr>
      </table>























</body>
</html>