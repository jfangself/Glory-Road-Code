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
@WebServlet(urlPatterns = "/android/addKind.jsp")
public class AddKindServlet extends BaseServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("gbk");
		// ��ȡ�������
		String name = request.getParameter("kindName");
		String desc = request.getParameter("kindDesc");
		// ��ȡϵͳҵ���߼����
		AuctionManager auctionManager = (AuctionManager) getCtx()
				.getBean("mgr");
		// ����ҵ���߼������ҵ�񷽷���������
		int kindId = auctionManager.addKind(name, desc);
		response.setContentType("text/html; charset=GBK");
		// ���ӳɹ�
		if (kindId > 0) {
			response.getWriter().println("��ϲ�����������ӳɹ�!");
		} else {
			response.getWriter().println("�Բ�����������ʧ��!");
		}
	}
}