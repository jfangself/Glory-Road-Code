package org.crazyit.auction.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.auction.business.BidBean;
import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.servlet.base.BaseServlet;

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
@WebServlet(urlPatterns = "/android/delItem.jsp")
public class DelItemServlet extends BaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html; charset=GBK");
		try {
			// 获取请求参数
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			System.out.println("itemId:" + itemId);
			// 获取系统业务逻辑组件
			AuctionManager auctionManager = (AuctionManager) getCtx().getBean(
					"mgr");
			List<BidBean> bids = (List<BidBean>) auctionManager
					.getBidByItem(itemId);
			if (bids.size() > 0) {
				response.getWriter().println("该物品已有竞价关联，不可删除！");
			} else {
				auctionManager.delItem(itemId);
				response.getWriter().println("恭喜您，物品删除成功!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("对不起，物品删除失败!");
		}
	}
}