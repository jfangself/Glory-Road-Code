package org.crazyit.auction.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.auction.business.ItemBean;
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
@WebServlet(urlPatterns = "/android/delKind.jsp")
public class DelKindServlet extends BaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html; charset=GBK");
		try {
			// ��ȡ�������
			int kindId = Integer.parseInt(request.getParameter("kindId"));
			System.out.println("kindId:" + kindId);
			// ��ȡϵͳҵ���߼����
			AuctionManager auctionManager = (AuctionManager) getCtx().getBean(
					"mgr");
			ArrayList<ItemBean> items = (ArrayList<ItemBean>) auctionManager
					.getAllItemsByKind(kindId);
			if (items.size() > 0) {
				response.getWriter().println("������������Ʒ����������ɾ��!");
			} else {
				auctionManager.delKind(kindId);
				response.getWriter().println("��ϲ��������ɾ���ɹ�!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("�Բ�������ɾ��ʧ��!");
		}
	}
}