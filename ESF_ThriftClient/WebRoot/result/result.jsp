<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>接口应答</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="json,格式化,高亮">
<meta name="keywords" content="json,格式化,高亮">
<script src="<%=basePath%>result/c.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="<%=basePath%>result/s.css" type="text/css" rel="stylesheet"></link>
</head>
<body>
	<a href="javascript:history.back()">返回上一页</a> 
	<br>
	<a href="<%=basePath%>index.jsp">返回服务列表</a>
	<br><br>		
	<div class="HeadersRow">
		<h3 id="HeaderSubTitle">请求:</h3>
		<textarea id="req"><%=request.getAttribute("req")%></textarea>
	</div>
	<div id="ControlsRowReq">
		<input type="button" value="格式化" onclick="ProcessReq()" /> 
		<span id="TabSizeHolderReq"> 缩进量 <select id="TabSizeReq"
			onchange="TabSizeChangedReq()">
				<option value="1">1</option>
				<option value="2" selected="true">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
		</select>
		</span> <label for="QuoteKeysReq"> <input type="checkbox" id="QuoteKeysReq"
			onclick="QuoteKeysClickedReq()" checked="true" /> 引号
		</label>&nbsp; <a href="javascript:void(0);" onclick="SelectAllClickedReq()">全选</a>
		&nbsp; <span id="CollapsibleViewHolderReq"> <label
			for="CollapsibleViewReq"> <input type="checkbox"
				id="CollapsibleViewReq" onclick="CollapsibleViewClickedReq()"
				checked="true" /> 显示控制
		</label>
		</span> <span id="CollapsibleViewDetailReq"> <a
			href="javascript:void(0);" onclick="ExpandAllClickedReq()">展开</a> <a
			href="javascript:void(0);" onclick="CollapseAllClickedReq()">叠起</a> <a
			href="javascript:void(0);" onclick="CollapseLevelReq(3)">2级</a> <a
			href="javascript:void(0);" onclick="CollapseLevelReq(4)">3级</a> <a
			href="javascript:void(0);" onclick="CollapseLevelReq(5)">4级</a> <a
			href="javascript:void(0);" onclick="CollapseLevelReq(6)">5级</a> <a
			href="javascript:void(0);" onclick="CollapseLevelReq(7)">6级</a> <a
			href="javascript:void(0);" onclick="CollapseLevelReq(8)">7级</a> <a
			href="javascript:void(0);" onclick="CollapseLevelReq(9)">8级</a>
		</span>
	</div>
	<div id="CanvasReq" class="CanvasReq"></div>
	
	<br><br>
		
	<div class="HeadersRow">
		<h3 id="HeaderSubTitle">应答:</h3>
		<textarea id="RawJson"><%=request.getAttribute("resp")%></textarea>
	</div>
	<div id="ControlsRow">
		<input type="button" value="格式化" onclick="Process()" /> <span
			id="TabSizeHolder"> 缩进量 <select id="TabSize"
			onchange="TabSizeChanged()">
				<option value="1">1</option>
				<option value="2" selected="true">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
		</select>
		</span> <label for="QuoteKeys"> <input type="checkbox" id="QuoteKeys"
			onclick="QuoteKeysClicked()" checked="true" /> 引号
		</label>&nbsp; <a href="javascript:void(0);" onclick="SelectAllClicked()">全选</a>
		&nbsp; <span id="CollapsibleViewHolder"> <label
			for="CollapsibleView"> <input type="checkbox"
				id="CollapsibleView" onclick="CollapsibleViewClicked()"
				checked="true" /> 显示控制
		</label>
		</span> <span id="CollapsibleViewDetail"> <a
			href="javascript:void(0);" onclick="ExpandAllClicked()">展开</a> <a
			href="javascript:void(0);" onclick="CollapseAllClicked()">叠起</a> <a
			href="javascript:void(0);" onclick="CollapseLevel(3)">2级</a> <a
			href="javascript:void(0);" onclick="CollapseLevel(4)">3级</a> <a
			href="javascript:void(0);" onclick="CollapseLevel(5)">4级</a> <a
			href="javascript:void(0);" onclick="CollapseLevel(6)">5级</a> <a
			href="javascript:void(0);" onclick="CollapseLevel(7)">6级</a> <a
			href="javascript:void(0);" onclick="CollapseLevel(8)">7级</a> <a
			href="javascript:void(0);" onclick="CollapseLevel(9)">8级</a>
		</span>
	</div>
	<div id="Canvas" class="Canvas"></div>
	<script type="text/javascript" src="<%=basePath%>result/urchin.js"></script>
	<script type="text/javascript" src="<%=basePath%>result/m.js"></script>
</body>
</html>

