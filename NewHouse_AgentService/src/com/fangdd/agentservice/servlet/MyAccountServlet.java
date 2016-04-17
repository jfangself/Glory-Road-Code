package com.fangdd.agentservice.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fangdd.agentservice.action.MyAccountAction;
import com.fangdd.agentservice.bean.Get_account_trade_record;
import com.fangdd.utils.StringUtil;

@WebServlet(urlPatterns = "/agentService/myAccountServlet")
public class MyAccountServlet extends HttpServlet {
	private com.fangdd.agentservice.action.MyAccountAction MyAccountAction;
	private JSONObject jsonObject;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		MyAccountAction = new MyAccountAction();
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		switch (action) {
		case "get_account_balance":
			this.get_account_balance(request, response);
			break;
		case "get_account_trade_record":
			this.get_account_trade_record(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 查询我的资金账户余额信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void get_account_balance(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));

		jsonObject = MyAccountAction.get_account_balance(user_id);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}

	/**
	 * 查询我的资金账户交易明细
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void get_account_trade_record(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int trade_type = Integer.parseInt(request.getParameter("trade_type"));
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		int page_index = Integer.parseInt(request.getParameter("page_index"));
		int page_size = Integer.parseInt(request.getParameter("page_size"));

		Get_account_trade_record Get_account_trade_record = new Get_account_trade_record();
		Get_account_trade_record.setUser_id(user_id);
		Get_account_trade_record.setTrade_type(trade_type);
		if (!StringUtil.validateNull(start_time)) {
			Get_account_trade_record.setStart_time(start_time);
		}
		if (!StringUtil.validateNull(end_time)) {
			Get_account_trade_record.setEnd_time(end_time);
		}
		Get_account_trade_record.setPage_index(page_index);
		Get_account_trade_record.setPage_size(page_size);

		jsonObject = MyAccountAction
				.get_account_trade_record(Get_account_trade_record);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}
}