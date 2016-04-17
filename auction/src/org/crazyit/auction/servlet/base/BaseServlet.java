package org.crazyit.auction.servlet.base;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
public class BaseServlet extends HttpServlet {
	private ApplicationContext ctx;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 获取Web应用中的ApplicationContext实例
		ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
	}

	// 返回Web应用中的Spring容器
	public ApplicationContext getCtx() {
		return this.ctx;
	}
}