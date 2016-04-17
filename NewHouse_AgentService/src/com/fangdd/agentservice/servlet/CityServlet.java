package com.fangdd.agentservice.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fangdd.agentservice.action.CityAction;

@WebServlet(urlPatterns = "/agentService/cityServlet")
public class CityServlet extends HttpServlet {
	private CityAction CityAction;
	private JSONObject jsonObject;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		CityAction = new CityAction();
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		switch (action) {
		case "get_publish_time":
			this.get_publish_time(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 查看某城市开通企业版结佣的时间点
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void get_publish_time(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int city_id = Integer.parseInt(request.getParameter("city_id"));

		jsonObject = CityAction.get_publish_time(city_id);
		String resp = jsonObject.toString();
		request.setAttribute("resp", resp);
		request.getRequestDispatcher("/result/result.jsp").forward(request,
				response);
	}
}