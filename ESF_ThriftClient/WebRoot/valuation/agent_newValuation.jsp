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

<title>估价服务</title>
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
<script src="<%=basePath%>js/valuation/agent_newValuation.js"
	type="text/javascript"></script>
</head>

<body>
	<center>
		<div>
			<h1>添加经纪人估价房源接口</h1>
			<br>
			<form id="agent_newValuation"
				action="<%=basePath%>thrift/valuationServlet" method="post">
				<input type="hidden" name="action" value="agent_newValuation">
				<table border="1">
					<tr>
						<td>参数名：</td>
						<td>参数值：<font size=5 color="red">*</font>为必填项
						</td>
						<td>参数说明：</td>
					</tr>
					<tr>
						<td>OwnerId<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="OwnerId" name="OwnerId"></td>
						<td>业主ID</td>
					</tr>
					<tr>
						<td>HouseId<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="HouseId" name="HouseId"></td>
						<td>房源ID</td>
					</tr>
					<tr>
						<td>AgentId<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="AgentId" name="AgentId"></td>
						<td>经纪人ID</td>
					</tr>
					<tr>
					<tr>
						<td>Price<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="Price" name="Price"></td>
						<td>房源估价</td>
					</tr>
					<tr>
					<tr>
						<td>CellMinPrice<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="CellMinPrice" name="CellMinPrice"></td>
						<td>小区最小估价/平米</td>
					</tr>
					<tr>
						<td>CellMaxPrice<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="CellMaxPrice" name="CellMaxPrice"></td>
						<td>小区最大估价/平米</td>
					</tr>
					<tr>
						<td>Reason<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="Reason" name="Reason"></td>
						<td>房源估价原因</td>
					</tr>
					<tr>
						<td><input type="submit" value="提交"></td>
						<td><input type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
			<a href="<%=basePath%>valuation/index.jsp">返回估价服务接口列表</a>
			<br> 
			<a href="<%=basePath%>index.jsp">返回服务列表</a>
		</div>
	</center>
</body>
</html>
