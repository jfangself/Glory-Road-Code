package org.crazyit.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.servlet.base.BaseServlet;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns = "/android/addItem.jsp")
public class AddItemServlet extends BaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// ��ȡuserId
		Integer userId = (Integer) request.getSession(true).getAttribute(
				"userId");
		request.setCharacterEncoding("gbk");
		// �����������
		String itemName = request.getParameter("itemName");
		String itemDesc = request.getParameter("itemDesc");
		String remark = request.getParameter("itemRemark");
		String initPrice = request.getParameter("initPrice");
		String kindId = request.getParameter("kindId");
		String avail = request.getParameter("availTime");
		// ��ȡҵ���߼����
		AuctionManager auctionManager = (AuctionManager) getCtx()
				.getBean("mgr");
		// ����ҵ���߼�����ķ����������Ʒ
		int itemId = auctionManager.addItem(itemName, itemDesc, remark,
				Double.parseDouble(initPrice), Integer.parseInt(avail),
				Integer.parseInt(kindId), userId);
		response.setContentType("text/html; charset=GBK");
		// ��ӳɹ�
		if (itemId > 0) {
			response.getWriter().println("��ϲ������Ʒ��ӳɹ�!");
		} else {
			response.getWriter().println("�Բ�����Ʒ���ʧ��!");
		}
	}
}