<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2010, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>����������Ʒ</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td>
<br />
<table width="80%" align="center" cellpadding="0"
	cellspacing="1" style="border:1px solid black">
<tr>
	<td colspan="4" ><div class="mytitle">����ǰ��������Ʒ��</div></td> 
</tr>
<tr  height="30">
	<td><b>��Ʒ��</b></td>
	<td><b>��Ʒ����</b></td>
	<td><b>Ӯȡ�۸�</b></td>
	<td><b>��Ʒ��ע</b></td>
	<td><b>����</b></td>
</tr>
<s:iterator id="item" value="items" status="st">
	<tr height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
		<td><s:property value="name"/></td>
		<td><s:property value="kind"/></td>
		<td><s:property value="maxPrice"/></td>
		<td><s:property value="remark"/></td>
		<td><a onclick="javascript:if (confirm('ȷ��ɾ����')) { return true;}else{return false;};" href="proDelItem.action?itemId=<s:property value="id"/>">ɾ��</a></td>
	</tr>
</s:iterator>
<%
String message=(String)request.getAttribute("DelItemAction");
if(message!=null && !("".equalsIgnoreCase(message)))
{
%>
	<script language="javascript">
		alert("<%=message%>");
	</script>
<%
}
%>
</table>
</td>
</tr>
<tr>
<td>
<br />
<h3>��������Ʒ</h3>
<div align="center">
<s:actionerror/>
<s:form action="proAddItem">
<s:textfield name="name" label="��Ʒ��"/>
<s:textfield name="desc" label="��Ʒ����"/>
<s:textfield name="remark" label="��Ʒ��ע"/>
<s:textfield name="initPrice" label="���ļ۸�"/>
<s:select name="avail" list="#{'1':'һ��','2':'����','3':'����','4':'����',
	'5':'����','6':'һ������','7':'һ����','8':'һ��'}"
	label="��Чʱ��"/>
<s:select list="kinds" label="��Ʒ����" name="kind"
	listKey="id"
	listValue="kindName"/>
<s:textfield name="vercode" label="��֤��"/>
<s:submit value="����"/>
</s:form>
��֤�룺<img name="d" src="authImg.jpg">
</div>
</td>
</tr>
</table>
</body>
</html>