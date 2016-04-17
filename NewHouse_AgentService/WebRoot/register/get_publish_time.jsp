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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=basePath%>js/city/get_publish_time.js"
	type="text/javascript"></script>
</head>

<body>
	<center>
			<h1>查看某城市开通企业版结佣的时间点接口</h1>
			<br>
			<form id="get_publish_time"
				action="<%=basePath%>agentService/cityServlet" method="post">
				<input type="hidden" name="action" value="get_publish_time">
				<table border="1">
					<tr>
						<td>参数名：</td>
						<td>参数值：<font size=5 color="red">*</font>为必填项
						</td>
					</tr>
					<tr>
						<td>city_id<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="city_id" name="city_id"></td>
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
