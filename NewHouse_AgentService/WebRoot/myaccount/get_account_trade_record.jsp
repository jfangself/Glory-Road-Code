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
<link rel="stylesheet" href="css/smoothness/jquery.ui.css" type="text/css" />
<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.ui.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.metadata.js" type="text/javascript"></script>
<script src="<%=basePath%>js/myaccount/get_account_trade_record.js"
	type="text/javascript"></script>
</head>

<body>
	<center>
			<h1>查询我的资金账户交易明细接口</h1>
			<br>
			<form id="get_account_trade_record"
				action="<%=basePath%>agentService/myAccountServlet" method="post">
				<input type="hidden" name="action" value="get_account_trade_record">
				<table border="1">
					<tr>
						<td>参数名：</td>
						<td>参数值：<font size=5 color="red">*</font>为必填项
						</td>
						<td>参数说明：</td>
					</tr>
					<tr>
						<td>user_id<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="user_id" name="user_id"></td>
						<td>用户id，即账户id</td>
					</tr>
					<tr>
						<td>trade_type<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="trade_type" name="trade_type"></td>
						<td>交易类型：0-查询全部;1-佣金;2-提现;3-转账;</td>
					</tr>
					<tr>
						<td>start_time:
						</td>
						<td><input type="text" id="start_time" name="start_time" readonly></td>
						<td>查询开始时间，不填则查全部</td>
					</tr>
					<tr>
						<td>end_time:
						</td>
						<td><input type="text" id="end_time" name="end_time" readonly></td>
						<td>查询结束时间，不填则查全部</td>
					</tr>
					<tr>
						<td>page_index<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="page_index" name="page_index"></td>
						<td>查询分页的页码：从第0页开始</td>
					</tr>
					<tr>
						<td>page_size<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="page_size" name="page_size"></td>
						<td>每页返回数量</td>
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
