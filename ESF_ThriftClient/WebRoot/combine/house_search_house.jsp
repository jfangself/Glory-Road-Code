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
<script src="<%=basePath%>js/combine/house_search_house.js"
	type="text/javascript"></script>
</head>

<body>
	<center>
		<div>
			<h1>查询房源列表接口</h1>
			<br>
			<form id="house_search_house"
				action="<%=basePath%>thrift/combineServlet" method="post">
				<input type="hidden" name="action" value="house_search_house">
				<table border="1">
					<tr>
						<td>参数名：</td>
						<td>参数值：<font size=5 color="red">*</font>为必填项</td>
						<td>参数说明：</td>
					</tr>
					<tr>
						<td>cityId<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="cityId" name="cityId"></td>
						<td>城市ID</td>
					</tr>
					<tr>
						<td>Property<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="Property" name="Property"></td>
						<td>房源属性：2自售；5名单</td>
					</tr>
					<tr>
						<td>cellId:</td>
						<td><input type="text" id="cellId" name="cellId"></td>
						<td>小区ID</td>
					</tr>
					<tr>
					<tr>
						<td>pageNo:</td>
						<td><input type="text" id="pageNo" name="pageNo"></td>
						<td>当前页数,从0开始</td>
					</tr>
					<tr>
					<tr>
						<td>pageSize:</td>
						<td><input type="text" id="pageSize" name="pageSize"></td>
						<td>页面大小</td>
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
