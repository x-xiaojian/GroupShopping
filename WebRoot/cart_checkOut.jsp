<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="com.tg.form.MemberForm"%>
<%java.util.Date date=new java.util.Date();%>
<jsp:useBean id="dao" scope="page" class="com.tg.dao.MemberDao"/>
<%

MemberForm form=(MemberForm)session.getAttribute("memberform");
%>
<html>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
}
}

}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����</title>

<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<table width="730" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
   <td width="730"  align="center">
   <form name="form" method="post" action="cart_checkOutOrder.jsp"  onSubmit="checkEmpty(form)">
		  <table width="68%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" colspan="2"> <div align="center" class="style1">ע�⣺������Ҫ�����Ƿ��ύ����������ɲ���Ҫ���鷳�� </div></td>
            </tr>
			   <tr>
              <td height="30"><div align="center">������ţ�</div></td>
              <td>&nbsp;<input type="hidden" name="number" value="<%=date.getTime()%>"><%=date.getTime()%></td>
            </tr>
            <tr>
              <td width="24%" height="30"><div align="center">��Ա���ƣ�</div></td>
              <td width="76%">&nbsp;<input type="text" name="usename" value="<%=form.getUsename()%>"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">��ʵ������</div></td>
              <td>&nbsp;<input type="text" name="name" value="<%=form.getName()%>"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">��ϵ��ַ��</div></td>
              <td>&nbsp;<input type="text" name="address"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">��ϵ�绰��</div></td>
              <td>&nbsp;<input type="text" name="tel"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">���ʽ��</div></td>
              <td>&nbsp;
			  <select name="setMoney" class="textarea">
			        <option value="">��ѡ��</option>
      <option value="���и���">���и���</option>
      <option value="��������">��������</option>
      <option value="�ֽ�֧��">�ֽ�֧��</option>
    </select>
			  </td>
            </tr>

            <tr>
              <td height="30"><div align="center">���ͷ�ʽ��</div></td>
              <td>&nbsp;<select name="post" class="textarea">
			        <option value="">��ѡ��</option>
      <option value="��ͨ�ʼ�">��ͨ�ʼ�</option>
      <option value="�ؿ�ר��">�ؿ�ר��</option>
      <option value="EMSר�ݷ�ʽ">EMSר�ݷ�ʽ</option>
    </select>
			  
			  </td>
            </tr>
            <tr>
              <td height="60"><div align="center">��ע��Ϣ��</div></td>
              <td>&nbsp;<textarea name="bz"></textarea></td>
            </tr>
        </table>
		  <br>

                <input type="submit" name="Submit2" value="�ύ">&nbsp;
               <input type="reset" name="reset" value="���">&nbsp;
          <input type="button" name="back" value="����" onClick="javasrcipt:history.go(-1)">
      </form>
</td>
  </tr>
</table>

</body>
</html>
