package com.fangdd.thrift.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fangdd.thrift.action.ValuationThriftAction;
import com.fangdd.thrift.valuation.request.NewValuationRequest;
import com.fangdd.thrift.valuation.response.AgentValuationResponse;
import com.google.gson.Gson;

/**
 * 估价服务
 * 
 * @author hexin
 * 
 */
@WebServlet(urlPatterns = "/thrift/valuationServlet")
public class ValuationServlet extends HttpServlet {
	private ValuationThriftAction ValuationThriftAction;
	private Gson Gson;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ValuationThriftAction = new ValuationThriftAction();
		Gson = new Gson();

	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		switch (action) {
		case "agent_newValuation":
			this.agent_newValuation(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 添加经纪人估价房源
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void agent_newValuation(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		long OwnerId = Long.parseLong(request.getParameter("OwnerId"));
		long HouseId = Long.parseLong(request.getParameter("HouseId"));
		long AgentId = Long.parseLong(request.getParameter("AgentId"));
		double Price = Double.parseDouble(request.getParameter("Price"));
		double CellPrice = Double.parseDouble(request.getParameter("Price"));
		double CellMinPrice = Double.parseDouble(request
				.getParameter("CellMinPrice"));
		double CellMaxPrice = Double.parseDouble(request
				.getParameter("CellMaxPrice"));
		String Reason = request.getParameter("Reason");

		NewValuationRequest NewValuationRequest = new NewValuationRequest();
		NewValuationRequest.setOwnerId(OwnerId);
		NewValuationRequest.setHouseId(HouseId);
		NewValuationRequest.setAgentId(AgentId);
		NewValuationRequest.setPrice(Price);
		NewValuationRequest.setCellPrice(CellPrice);
		NewValuationRequest.setCellMinPrice(CellMinPrice);
		NewValuationRequest.setCellMaxPrice(CellMaxPrice);
		NewValuationRequest.setReason(Reason);
		AgentValuationResponse AgentValuationResponse = ValuationThriftAction
				.agent_newValuation(NewValuationRequest);
		String req = Gson.toJson(NewValuationRequest);
		String resp = Gson.toJson(AgentValuationResponse);
		request.setAttribute("req", req);
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}
}