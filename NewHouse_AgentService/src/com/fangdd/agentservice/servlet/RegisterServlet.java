package com.fangdd.agentservice.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fangdd.agentservice.action.RegisterAction;

@WebServlet(urlPatterns = "/agentService/registerServlet")
public class RegisterServlet extends HttpServlet {
	private RegisterAction RegisterAction;
	private JSONObject jsonObject;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		RegisterAction = new RegisterAction();
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		switch (action) {
		case "enterprise_register":
			this.enterprise_register(request, response);
			break;
		case "is_regist_enterprise":
			this.is_regist_enterprise(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 经纪服务门店申请资金账号开户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void enterprise_register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int shopId = Integer.parseInt(request.getParameter("shopId"));

		jsonObject = RegisterAction.enterprise_register(shopId);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}

	/**
	 * 经纪服务查询门店是否激活企业版
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void is_regist_enterprise(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String shopIdList = request.getParameter("shopIdList");

		jsonObject = RegisterAction.is_regist_enterprise(shopIdList);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}
}