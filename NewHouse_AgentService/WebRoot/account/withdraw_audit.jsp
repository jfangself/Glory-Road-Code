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
<script src="<%=basePath%>js/account/withdraw_audit.js"
	type="text/javascript"></script>
</head>

<body>
	<center>
			<h1>审核提现单接口</h1>
			<br>
			<form id="withdraw_audit"
				action="<%=basePath%>agentService/accountServlet" method="post">
				<input type="hidden" name="action" value="withdraw_audit">
				<table border="1">
					<tr>
						<td>参数名：</td>
						<td>参数值：<font size=5 color="red">*</font>为必填项
						</td>
						<td>参数说明：</td>
					</tr>
					<tr>
						<td>settle_id<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="settle_id" name="settle_id"></td>
						<td>提现单ID</td>
					</tr>
					<tr>
						<td>status<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="status" name="status"></td>
						<td>审核结果：3-拒绝；2-通过；</td>
					</tr>
					<tr>
						<td>comment:
						</td>
						<td><input type="text" id="comment" name="comment"></td>
						<td>审核意见</td>
					</tr>
					<tr>
						<td>oper_user_id<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="oper_user_id" name="oper_user_id"></td>
						<td>操作人id(操作人相关信息由云系统提供)</td>
					</tr>
					<tr>
						<td>oper_user_name<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="oper_user_name" name="oper_user_name"></td>
						<td>操作人名称</td>
					</tr>
					<tr>
						<td>oper_role<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="oper_role" name="oper_role"></td>
						<td>操作人角色</td>
					</tr>
					<tr>
						<td>oper_mobile<font size=5 color="red">*</font>:
						</td>
						<td><input type="text" id="oper_mobile" name="oper_mobile"></td>
						<td>操作人手机号</td>
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
