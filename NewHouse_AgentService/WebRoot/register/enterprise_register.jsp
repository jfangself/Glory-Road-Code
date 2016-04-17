<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新房经纪服务企业版</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=basePath%>js/register/enterprise_register.js"
	type="text/javascript"></script>
</head>

<body>
	<center>
			<h1>经纪服务门店申请资金账号开户接口</h1>
			<br>
			<form id="enterprise_register"
				action="<%=basePath%>agentService/registerServlet" method="post">
				<input type="hidden" name="action" value="enterprise_register">
				<table border="1">
					<tr>
						<td>参数名：</td>
						<td>参数值：<font size=5 color="red">*</font>为必填项
						</td>
						<td>参数说明：</td>
					</tr>
					<tr>
						<td>shopId<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="shopId" name="shopId"></td>
						<td>门店ID</td>
					</tr>
					<tr>
						<td><input type="submit" value="提交"></td>
						<td><input type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
			<a href="<%=basePath%>index.jsp">返回新房经济服务企业版接口列表</a>
	</center>
</body>
</html>
