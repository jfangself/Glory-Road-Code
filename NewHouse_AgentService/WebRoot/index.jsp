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
</head>

<body>
	<center>
		<h1>新房经纪服务企业版接口列表</h1>
		<br> 
		<a href="<%=basePath%>register/enterprise_register.jsp">经纪服务门店申请资金账号开户(http://qiye.fangdd.net/external/enterprise_register.json)</a>
		<br><br> 
		<a href="<%=basePath%>register/is_regist_enterprise.jsp">经纪服务查询门店是否激活企业版(http://qiye.fangdd.net/external/is_regist_enterprise.json)</a>
		<br><br> 
		<a href="<%=basePath%>city/get_publish_time.jsp">查看某城市开通企业版结佣的时间点(http://qiye.fangdd.net/external/city/get_publish_time.json)</a>
		<br><br> 
		<a href="<%=basePath%>myaccount/get_account_balance.jsp">查询我的资金账户余额信息(http://qiye.fangdd.net/external/get_account_balance.json)</a>
		<br><br> 
		<a href="<%=basePath%>myaccount/get_account_trade_record.jsp">查询我的资金账户交易明细(http://qiye.fangdd.net/external/get_account_trade_record.json)</a>
		<br><br> 
		<a href="<%=basePath%>account/withdraw_audit.jsp">审核提现单(http://qiye.fangdd.net/external/account/withdraw_audit.json)</a>
		<br><br> 
		<a href="<%=basePath%>account/withdraw_list.jsp">查询提现单列表(http://qiye.fangdd.net/external/account/withdraw_list.json)</a>
		<br><br> 
		<a href="<%=basePath%>account/withdraw_oper_list.jsp">查询指定提现单操作明细(http://qiye.fangdd.net/external/account/withdraw_oper_list.json)</a>
		<br><br> 
		<a href="<%=basePath%>account/withdraw_detail.jsp">查询指定提现单详情(http://qiye.fangdd.net/external/account/withdraw_detail.json)</a>
		<br><br> 
		<a href="<%=basePath%>account/receive_pay_result.jsp">接收支付系统付款结果接口(http://qiye.fangdd.net/external/account/receive_pay_result.json)</a>
	</center>
</body>
</html>
