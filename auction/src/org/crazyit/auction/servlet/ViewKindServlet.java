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
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
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
		// ��ȡҵ���߼����
		AuctionManager auctionManager = (AuctionManager) getCtx()
				.getBean("mgr");
		// ��ȡϵͳ��������Ʒ����
		List<KindBean> kinds = auctionManager.getAllKind();
		// ��������Ʒ�����װ��JSONArray
		JSONArray jsonArr = new JSONArray();
		for (KindBean kind : kinds) {
			jsonArr.put(new JSONObject(kind));
		}
		response.setContentType("text/html; charset=GBK");
		System.out.println("response:" + jsonArr.toString());
		// ��JSONArrayת����JSON�ַ�����������ͻ���
		response.getWriter().println(jsonArr.toString());
	}
}