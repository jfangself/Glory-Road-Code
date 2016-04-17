package org.crazyit.auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.auction.business.KindBean;
import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.servlet.base.BaseServlet;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns = "/android/viewKind.jsp")
public class ViewKindServlet extends BaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 获取业务逻辑组件
		AuctionManager auctionManager = (AuctionManager) getCtx()
				.getBean("mgr");
		// 获取系统中所有物品种类
		List<KindBean> kinds = auctionManager.getAllKind();
		// 将所有物品种类包装成JSONArray
		JSONArray jsonArr = new JSONArray();
		for (KindBean kind : kinds) {
			jsonArr.put(new JSONObject(kind));
		}
		response.setContentType("text/html; charset=GBK");
		System.out.println("response:" + jsonArr.toString());
		// 将JSONArray转换成JSON字符串后输出到客户端
		response.getWriter().println(jsonArr.toString());
	}
}