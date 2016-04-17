package org.crazyit.auction.servlet.base;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
public class BaseServlet extends HttpServlet {
	private ApplicationContext ctx;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// ��ȡWebӦ���е�ApplicationContextʵ��
		ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
	}

	// ����WebӦ���е�Spring����
	public ApplicationContext getCtx() {
		return this.ctx;
	}
}