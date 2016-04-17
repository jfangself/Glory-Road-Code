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

<title>组合服务</title>
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
<script src="<%=basePath%>js/combine/cell_search_cell.js" type="text/javascript"></script>

</head>

<body>
	<center>
		<div>
			<h1>查询小区接口</h1>
			<br>
			<form id="cell_search_cell"
				action="<%=basePath%>thrift/combineServlet" method="post">
				<input type="hidden" name="action" value="cell_search_cell">
				<table border="1">
					<tr>
						<td>参数名：</td>
						<td>参数值：<font size=5 color="red">*</font>为必填项</td>
						<td>参数说明：</td>
					</tr>
					<tr>
						<td>keyword<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="keyword" name="keyword"></td>
						<td>关键字</td>
					</tr>
					<tr>
						<td>cityId<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="cityId" name="cityId"></td>
						<td>城市ID</td>
					</tr>
					<tr>
						<td><input type="submit" value="提交"></td>
						<td><input type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
			<a href="<%=basePath%>combine/index.jsp">返回组合服务接口列表</a>
			<br> 
			<a href="<%=basePath%>index.jsp">返回服务列表</a>
		</div>
	</center>
</body>
</html>
