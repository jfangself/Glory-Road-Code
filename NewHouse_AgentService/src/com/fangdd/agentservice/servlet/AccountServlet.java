package com.fangdd.agentservice.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fangdd.agentservice.action.AccountAction;
import com.fangdd.agentservice.bean.Withdraw_audit;
import com.fangdd.agentservice.bean.Withdraw_list;
import com.fangdd.utils.StringUtil;

@WebServlet(urlPatterns = "/agentService/accountServlet")
public class AccountServlet extends HttpServlet {
	private AccountAction AccountAction;
	private JSONObject jsonObject;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		AccountAction = new AccountAction();
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		switch (action) {
		case "withdraw_audit":
			this.withdraw_audit(request, response);
			break;
		case "withdraw_list":
			this.withdraw_list(request, response);
			break;
		case "withdraw_oper_list":
			this.withdraw_oper_list(request, response);
			break;
		case "withdraw_detail":
			this.withdraw_detail(request, response);
			break;
		case "receive_pay_result":
			this.receive_pay_result(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 审核提现单
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void withdraw_audit(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int settle_id = Integer.parseInt(request.getParameter("settle_id"));
		int status = Integer.parseInt(request.getParameter("status"));
		String comment = request.getParameter("comment");
		int oper_user_id = Integer.parseInt(request
				.getParameter("oper_user_id"));
		String oper_user_name = request.getParameter("oper_user_name");
		String oper_role = request.getParameter("oper_role");
		String oper_mobile = request.getParameter("oper_mobile");

		Withdraw_audit Withdraw_audit = new Withdraw_audit();
		Withdraw_audit.setSettle_id(settle_id);
		Withdraw_audit.setStatus(status);
		if (!StringUtil.validateNull(comment)) {
			Withdraw_audit.setComment(comment);
		}
		Withdraw_audit.setOper_user_id(oper_user_id);
		Withdraw_audit.setOper_user_name(oper_user_name);
		Withdraw_audit.setOper_role(oper_role);
		Withdraw_audit.setOper_mobile(oper_mobile);

		jsonObject = AccountAction.withdraw_audit(Withdraw_audit);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}

	/**
	 * 查询提现单列表
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void withdraw_list(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int city_id = 0;
		if (!StringUtil.validateNull(request.getParameter("city_id"))) {
			city_id = Integer.parseInt(request.getParameter("city_id"));
		}
		int status = Integer.parseInt(request.getParameter("status"));
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		int settle_id = 0;
		if (!StringUtil.validateNull(request.getParameter("settle_id"))) {
			settle_id = Integer.parseInt(request.getParameter("settle_id"));
		}
		String company_key = request.getParameter("company_key");
		String oper_user = request.getParameter("oper_user");
		int page_index = Integer.parseInt(request.getParameter("page_index"));
		int page_size = Integer.parseInt(request.getParameter("page_size"));

		Withdraw_list Withdraw_list = new Withdraw_list();
		if (city_id > 0) {
			Withdraw_list.setCity_id(city_id);
		}
		Withdraw_list.setStatus(status);
		if (!StringUtil.validateNull(start_time)) {
			Withdraw_list.setStart_time(start_time);
		}
		if (!StringUtil.validateNull(end_time)) {
			Withdraw_list.setEnd_time(end_time);
		}
		if (settle_id > 0) {
			Withdraw_list.setSettle_id(settle_id);
		}
		if (!StringUtil.validateNull(company_key)) {
			Withdraw_list.setCompany_key(company_key);
		}
		if (!StringUtil.validateNull(oper_user)) {
			Withdraw_list.setOper_user(oper_user);
		}
		Withdraw_list.setPage_index(page_index);
		Withdraw_list.setPage_size(page_size);

		jsonObject = AccountAction.withdraw_list(Withdraw_list);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}

	/**
	 * 查询指定提现单操作明细
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void withdraw_oper_list(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		int settle_id = Integer.parseInt(request.getParameter("settle_id"));

		jsonObject = AccountAction.withdraw_oper_list(settle_id);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}

	/**
	 * 查询指定提现单详情
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void withdraw_detail(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		int settle_id = Integer.parseInt(request.getParameter("settle_id"));

		jsonObject = AccountAction.withdraw_detail(settle_id);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}

	/**
	 * 接收支付系统付款结果
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void receive_pay_result(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String withdraw_id = request.getParameter("withdraw_id");
		int result = Integer.parseInt(request.getParameter("result"));
		String comment = request.getParameter("comment");

		jsonObject = AccountAction.receive_pay_result(withdraw_id, result,
				comment);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}
}