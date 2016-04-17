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
</head>

<body>
	<center>
		<h1>组合服务(combine.service)接口列表</h1><br>
		<a href="<%=basePath%>combine/cell_search_cell.jsp">查询小区(http://host/combine/cell/search_cell?data={})</a>
		<br><br> 
		<a href="<%=basePath%>combine/house_search_house.jsp">查询房源列表(http://host/combine/house/search_house?data={})</a>
		<br><br>
		<a href="<%=basePath%>index.jsp">返回服务列表</a>
	</center>
</body>
</html>
