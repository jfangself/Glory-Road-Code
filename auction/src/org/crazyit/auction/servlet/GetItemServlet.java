package org.crazyit.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.auction.business.ItemBean;
import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.servlet.base.BaseServlet;
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
@WebServlet(urlPatterns = "/android/getItem.jsp")
public class GetItemServlet extends BaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("gbk");
		// 获取物品的ID
		String itemId = request.getParameter("itemId");
		// 获取业务逻辑组件
		AuctionManager auctionManager = (AuctionManager) getCtx()
				.getBean("mgr");
		// 调用业务逻辑方法
		ItemBean itemBean = auctionManager.getItem(Integer.parseInt(itemId));
		// 将所有的物品种类包装成JSONObject
		JSONObject jsonObj = new JSONObject(itemBean);
		response.setContentType("text/html; charset=GBK");
		response.getWriter().println(jsonObj.toString());
	}
}