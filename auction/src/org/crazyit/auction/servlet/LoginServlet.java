package org.crazyit.auction.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.servlet.base.BaseServlet;
import org.json.JSONException;
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
@WebServlet(urlPatterns = "/android/login.jsp")
public class LoginServlet extends BaseServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		// ��ȡϵͳ��ҵ���߼����
		AuctionManager auctionManager = (AuctionManager) getCtx()
				.getBean("mgr");
		// ��֤�û���¼
		int userId = auctionManager.validLogin(user, pass);
		response.setContentType("text/html; charset=GBK");
		// ��¼�ɹ�
		if (userId > 0) {
			request.getSession(true).setAttribute("userId", userId);
		}
		try {
			// ����֤��userId��װ��JSONObject
			JSONObject jsonObj = new JSONObject().put("userId", userId);

			System.out.println("response:" + jsonObj.toString());
			// �����Ӧ
			response.getWriter().println(jsonObj.toString());
		} catch (JSONException ex) {
			ex.printStackTrace();
		}
	}
}